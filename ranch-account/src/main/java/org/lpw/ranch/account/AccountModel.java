package org.lpw.ranch.account;

import org.lpw.tephra.dao.model.Jsonable;
import org.lpw.tephra.dao.model.ModelSupport;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author lpw
 */
@Component(AccountModel.NAME + ".model")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Entity(name = AccountModel.NAME)
@Table(name = "t_account")
public class AccountModel extends ModelSupport {
    static final String NAME = "ranch.account";

    private String user; // 用户
    private String owner; // 所有者
    private int type; // 类型
    private int balance; // 余额
    private int deposit; // 存入总额
    private int withdraw; // 取出总额
    private int reward; // 奖励总额
    private int profit; // 盈利总额
    private int consume; // 消费总额
    private int remitIn; // 汇入总额
    private int remitOut; // 汇出总额
    private int refund; // 退款总额
    private int pending; // 待结算总额
    private String checksum; // 校验值
    private String lockId; // 全局锁ID

    @Jsonable
    @Column(name = "c_user")
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Jsonable
    @Column(name = "c_owner")
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Jsonable
    @Column(name = "c_type")
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Jsonable
    @Column(name = "c_balance")
    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Jsonable
    @Column(name = "c_deposit")
    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    @Jsonable
    @Column(name = "c_withdraw")
    public int getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(int withdraw) {
        this.withdraw = withdraw;
    }

    @Jsonable
    @Column(name = "c_reward")
    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    @Jsonable
    @Column(name = "c_profit")
    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    @Jsonable
    @Column(name = "c_consume")
    public int getConsume() {
        return consume;
    }

    public void setConsume(int consume) {
        this.consume = consume;
    }

    @Jsonable
    @Column(name = "c_remit_in")
    public int getRemitIn() {
        return remitIn;
    }

    public void setRemitIn(int remitIn) {
        this.remitIn = remitIn;
    }

    @Jsonable
    @Column(name = "c_remit_out")
    public int getRemitOut() {
        return remitOut;
    }

    public void setRemitOut(int remitOut) {
        this.remitOut = remitOut;
    }

    @Jsonable
    @Column(name = "c_refund")
    public int getRefund() {
        return refund;
    }

    public void setRefund(int refund) {
        this.refund = refund;
    }

    @Jsonable
    @Column(name = "c_pending")
    public int getPending() {
        return pending;
    }

    public void setPending(int pending) {
        this.pending = pending;
    }

    @Column(name = "c_checksum")
    public String getChecksum() {
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }

    public String getLockId() {
        return lockId;
    }

    public void setLockId(String lockId) {
        this.lockId = lockId;
    }
}
