package com.ys.hospital.tools;

import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.core.Converter;

import java.io.*;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * @Description: 方便复制bean属性的工具类
 * @author: yusheng
 * @create-date: 2019-10-19 17:34
 **/
public class BeanTool {

    // 使用WeakHashMap缓存,在内存不足时会自动释放
    //beanCopierMap
    private final static Map<String, BeanCopier> BEAN_COPIER_MAP = new WeakHashMap<>();
    //Converter
    private final static Map<String, Converter> CONVERTER_MAP = new WeakHashMap<>();
    //BeanCopier的对象锁，为了安全，启动同步机制
    private static Object beanCopierLock = new Object();
    //Converter的对象锁，为了安全，启动同步机制
    private static Object converterLock = new Object();

    /**
     * 浅拷贝
     * 复制对象属性，如果是引用数据类型的变量，则赋值引用地址（指针）
     *
     * @param src    被复制的对象
     * @param target 被赋值的对象
     */
    public static void copy(Object src, Object target) {
        BeanCopier bc = getBeanCopier(src, target, false);
        bc.copy(src, target, null);
    }

    /**
     * 浅拷贝
     * 使用自定义的属性转换器处理src对象的某属性的值，再赋值给target对象对应的同名的属性
     *
     * @param src       被复制的对象
     * @param target    被赋值的对象
     * @param converter 自定义转换器
     */
    public static void copy(Object src, Object target, Converter converter) {
        BeanCopier bc = getBeanCopier(src, target, true);
        bc.copy(src, target, converter);
    }

    /**
     * 浅拷贝
     * 对象属性复制，只复制fields中指定的属性，每个属性用逗号分隔
     *
     * @param src    被复制的对象
     * @param target 被赋值的对象
     * @param fields 指定的属性字符串，用逗号隔开，如 "id,name,phone"
     */
    public static void copySpecifiedFields(Object src, Object target, final String fields) {
        //获取一个BeanCopier
        BeanCopier bc = getBeanCopier(src, target, true);
        //复制指定属性
        bc.copy(src, target, newConverter(src, target, fields, true));
    }

    /**
     * 浅拷贝
     * 对象属性复制，排除指定属性
     *
     * @param src
     * @param target
     * @param fields
     */
    public static void copyExcludeFields(Object src, Object target, final String fields) {
        BeanCopier bc = getBeanCopier(src, target, true);
        bc.copy(src, target, newConverter(src, target, fields, false));
    }

    /**
     * 深拷贝
     *
     * @param src    被复制的对象
     * @param target 被赋值的对象
     */
    @SuppressWarnings("unchecked")
    public static void deepCopy(Object src, Object target) {
        if (src instanceof Serializable && target instanceof Serializable) {
            try {
                //生成一个字节输出流，用于在内存中暂存序列化的对象 srcObject
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                //生成一个对象输出流，用于把序列化的对象 srcObject，输出到字节输出流中
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                //输出 srcObject
                objectOutputStream.writeObject(src);
                //关闭对象输出流
                objectOutputStream.close();
                byteArrayOutputStream.close();

                //分配内存，写入原始对象，生成新对象
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                //生成一个对象输入流
                ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
                //调用objectInputStream生成新对象,然后把属性赋给target
                copy(objectInputStream.readObject(), target);
                //关闭对象输入流
                objectInputStream.close();
                byteArrayInputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            if (target instanceof Serializable) {
                System.out.println(src.getClass().getName() + "未序列化，深拷贝失败");
            } else {
                System.out.println(target.getClass().getName() + "未序列化，深拷贝失败");
            }
        }
    }

    /**
     * 深拷贝
     *
     * @param src         被复制的对象
     * @param targetClass 被赋值的对象的全类名
     * @param <T>         指定返回值的类型，和targetClass一样
     * @return targetClass的对象(复制了src的属性)
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public static <T> T deepCopy(Object src, Class<T> targetClass) {
        T targetObject = null;
        try {
            targetObject = targetClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (src instanceof Serializable && targetObject instanceof Serializable) {
            try {
                //生成一个字节输出流，用于在内存中暂存序列化的对象 srcObject
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                //生成一个对象输出流，用于把序列化的对象 srcObject，输出到字节输出流中
                ObjectOutputStream objectOutputStream = null;
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                //输出 srcObject
                objectOutputStream.writeObject(src);
                //关闭对象输出流
                objectOutputStream.close();
                byteArrayOutputStream.close();

                //分配内存，写入原始对象，生成新对象
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                //生成一个对象输入流
                ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
                //调用objectInputStream生成新对象,然后把属性赋给target
                copy(objectInputStream.readObject(), targetObject);
                //关闭对象输入流
                objectInputStream.close();
                byteArrayInputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return targetObject;
        } else {
            if (targetObject instanceof Serializable) {
                System.out.println(src.getClass().getName() + "未序列化，深拷贝失败");
            } else {
                assert targetObject != null;
                System.out.println(targetObject.getClass().getName() + "未序列化，深拷贝失败");
            }
        }
        return null;
    }

    /**
     * 创建BeanCopier，并缓存
     *
     * @param src
     * @param target
     * @param useConverter
     * @return
     */
    private static BeanCopier getBeanCopier(Object src, Object target, boolean useConverter) {
        String key = generateKey(src, target, useConverter);
        BeanCopier bc = BEAN_COPIER_MAP.get(key);
        if (null == bc) {
            synchronized (beanCopierLock) {
                bc = BEAN_COPIER_MAP.get(key);
                if (null == bc) {
                    bc = BeanCopier.create(src.getClass(), target.getClass(), useConverter);
                    BEAN_COPIER_MAP.put(key, bc);
                }
            }
        }
        return bc;
    }

    /**
     * new属性转换器
     *
     * @param fields        需要复制或排除的属性
     * @param fieldCopyFlag 属性复制标识 true:表明fields为需要复制的属性；false:表明fields是需要排除复制的属性
     * @return
     */
    private static Converter newConverter(Object src, Object target, final String fields, final boolean fieldCopyFlag) {
        //生成一个复制指定属性的converter的key
        String key = buildConverterKey(src, target, fields, fieldCopyFlag);
        //根据key去缓存中获取该converter
        Converter converter = CONVERTER_MAP.get(key);
        if (null == converter) {
            //当前线程中没有converter，获取对象锁，可能对象锁中有该converter
            synchronized (converterLock) {
                //当前线程得到对象锁后，获取指定的converter
                converter = CONVERTER_MAP.get(key);
                //如果对象锁的资源中没有指定的converter
                if (null == converter) {
                    //创建一个新的Converter，放在该对象锁中
                    converter = new Converter() {
                        /**
                         * Converter
                         * Converter会对一个实体类中的所有属性进行遍历
                         * 再通过get/set方法和属性名，获取src对象的属性，赋值到target对象的
                         *
                         * @param fieldValue 当前遍历到的实体类的一个属性对应的值
                         * @param fieldType  当前遍历到的实体类的一个属性对应的数据类型
                         * @param methodName 当前遍历到的实体类的一个属性对应的methodName（src对象的getXxxx,target对象的setXxxx)
                         * @return fieldValue 把当前遍历到的src对象的一个属性的值赋值给target对象的相同属性
                         */
                        @Override
                        public Object convert(Object fieldValue, Class fieldType, Object methodName) {
                            //setXxxx，获取子字符串，获取Xxxx，得到属性名，如Name
                            String field = methodName.toString().substring(3); // 得到属性名，如Name
                            //将首字母小写
                            field = field.substring(0, 1).toLowerCase() + field.substring(1);
                            if ((fieldCopyFlag && fields.contains(field)) || (!fieldCopyFlag && !fields.contains(field))) {
                                //根据fieldCopyFlag，选择是否把当前遍历到的src对象的一个属性的值赋值给target对象的相同属性
                                return fieldValue;
                            }
                            //防止检测到没有返回值
                            return null;
                        }
                    };
                    //创建Converter成功，放进对象锁的map中（缓存）
                    CONVERTER_MAP.put(key, converter);
                }
            }
        }
        return converter;
    }

    /**
     * key生成器
     * 根据src和target，useConverter生成一个关键字key
     *
     * @param src          被复制的对象
     * @param target       被赋值的对象
     * @param useConverter 是否使用转换器
     * @return key字符串：src的全类名+target全类名+(true||false)
     */
    private static String generateKey(Object src, Object target, boolean useConverter) {
        return src.getClass().getName() + target.getClass().getName() + String.valueOf(useConverter);
    }

    /**
     * 生成一个复制指定属性的转换器的key
     *
     * @param src      被复制的对象
     * @param target   被赋值的对象
     * @param fields   指定属性
     * @param copyFlag true:复制指定属性||false：复制除指定属性外的属性
     * @return key：复制指定属性的转换器的key
     */
    private static String buildConverterKey(Object src, Object target, String fields, boolean copyFlag) {
        //生成一个缓存用的baseKey
        String baseKey = generateKey(src, target, true);
        //拼接成一个复制指定属性的convert的key
        String key = baseKey + fields + String.valueOf(copyFlag);
        return key;
    }
}

