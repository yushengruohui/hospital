package com.ys.hospital.config;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.*;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: yusheng
 * @create-time 2019-10-23 23:09
 **/
@Aspect
@Configuration
public class MyDatabaseTransactionManagerConfig {
    //连接超时
    private static final int AOP_TIME_OUT = 50000;
    //切点
    private static final String AOP_POINTCUT_EXPRESSION = "execution(* com.ys.hospital.service..*.*(..))";

    @Resource
    private PlatformTransactionManager transactionManager;

    @Bean
    public TransactionInterceptor txAdvice() {
        //方法名和设置的字符串匹配，则按照相应设置的事务属性去执行相应事务
        NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();

        /** 只读事务，不做更新操作 */
        RuleBasedTransactionAttribute readOnlyTx = new RuleBasedTransactionAttribute();
        readOnlyTx.setReadOnly(true);
        readOnlyTx.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        /** 当前存在事务就使用当前事务，当前不存在事务就创建一个新的事务 */
        //基于规则的事务属性
        RuleBasedTransactionAttribute requiredTx = new RuleBasedTransactionAttribute();

        /** 什么异常需要回滚 */
        requiredTx.setRollbackRules(Collections.singletonList(new RollbackRuleAttribute(Exception.class)));
        requiredTx.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        requiredTx.setTimeout(AOP_TIME_OUT);

        Map<String, TransactionAttribute> methodMap = new HashMap<>();

        /** 可以提及事务或回滚事务的方法 */
        methodMap.put("add*", requiredTx);
        methodMap.put("insert*", requiredTx);
        methodMap.put("save*", requiredTx);
        methodMap.put("update*", requiredTx);
        methodMap.put("modify*", requiredTx);
        methodMap.put("edit*", requiredTx);
        methodMap.put("delete*", requiredTx);
        methodMap.put("remove*", requiredTx);
        methodMap.put("repair*", requiredTx);
        methodMap.put("binding*", requiredTx);

        /** 其他方法无事务，只读 */
        methodMap.put("*", readOnlyTx);
        source.setNameMap(methodMap);

        TransactionInterceptor txAdvice = new TransactionInterceptor(transactionManager, source);
        return txAdvice;
    }

    @Bean(name = "txAdviceAdvisor")
    public Advisor txAdviceAdvisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(AOP_POINTCUT_EXPRESSION);
        return new DefaultPointcutAdvisor(pointcut, txAdvice());
    }
}