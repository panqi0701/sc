package com.ddd.common.commandhandling.interceptor;


import com.ddd.common.command.Command;
import com.ddd.common.result.BaseResult;

/**
 * 命令拦截器
 * <p>
 * 支持排序
 *
 * @param <R> Result
 * @see org.springframework.core.annotation.Order
 * @see org.springframework.core.Ordered
 */
public interface CommandInterceptor<C extends Command<R>, R extends BaseResult> {

    /**
     * 支持的命令类型，返回null表示是一个全局CommandInterceptor（拦截所有command）
     *
     * @return 命令类型 or null
     */
    Class<C> supportCommandType();

    /**
     * 前置处理
     *
     * @param command 命令
     */
    void beforeHandle(C command);

    /**
     * 后置处理
     *
     * @param command 命令
     * @param result  结果
     */
    void afterHandle(C command, R result);
}
