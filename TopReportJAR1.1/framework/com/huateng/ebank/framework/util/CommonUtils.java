package com.huateng.ebank.framework.util;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;

import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.entity.data.flowManagement.Applydtl;
import com.huateng.ebank.framework.exceptions.CommonException;

public class CommonUtils{

    /**
     * 比较浮点数相等性时的默认容忍值。容忍值一般为最小精度的一半，
     * 这里的容忍值是建立在最小精度为0.01的情况下的(金额计算通常精度为分)
     */
    public static final double DEFAULT_TOLERANCE = 0.005;

    /**
     * 保存审批历史
     */
    public static void saveAppltyDtl(String appno, String attitude,
            String reason, String appType) throws CommonException{
        GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();

        Applydtl applydtl = new Applydtl();
        applydtl.setAppno(appno);
        applydtl.setApprover(globalInfo.getTlrno());
        applydtl.setApptype(appType);
        applydtl.setAttitude(attitude);
        applydtl.setReason(reason);
        applydtl.setBrcode(globalInfo.getBrcode());
        applydtl.setTxnDate(globalInfo.getTxdate());
        applydtl.setTimestamps(new Date());
        DAOUtils.getApplydtlDAO().insert(applydtl);
    }

    /**
     * 该方法是BeanUtils.copyProperties(dest, orig)的轻封装，仅仅捕捉异常，然后抛出CommonException。
     */
    public static Object copyProperties(Object dest, Object orig)
            throws CommonException{
        try{
            BeanUtils.copyProperties(dest, orig);
            return dest;
        }catch(IllegalAccessException e){
            throw new CommonException("copyProperties 抛出异常", e);
        }catch(InvocationTargetException e){
            throw new CommonException("copyProperties 抛出异常", e);
        }
    }

    /**
     * 考虑误差的情况下判断一个数字是否为0
     * 
     * @param d
     *            一个数字
     * @return 该数字被认为是0(允许一定误差)则返回true，否则返回false
     */
    public static boolean isZero(BigDecimal number){
        if(number == null) return false;
        return isEqual(number.doubleValue(), 0d);
    }

    /**
     * 考虑误差的情况下判断一个数字是否为0
     * 
     * @param d
     *            一个数字
     * @return 该数字被认为是0(允许默认误差)则返回true，否则返回false
     */
    public static boolean isZero(double d){
        return isEqual(d, 0d);
    }

    /**
     * 由于浮点数运算存在误差，有可能存在两个浮点数理论上相等而实际运算结果不同的情况。
     * 该方法比较两个浮点数时，只要两者之差小于一个默认容忍值即认为这两个数相等。
     * 
     * @param d1
     *            一个浮点数
     * @param d2
     *            另一个浮点数
     * @return 若两个浮点数之差小于默认容忍值则返回true，否则返回false
     */
    public static boolean isEqual(double d1, double d2){
        return Math.abs(d1 - d2) < DEFAULT_TOLERANCE;
    }

//del by zhaozhiguo
//    public static void processAccount(Integer txnLogId) throws CommonException{
//        if(SysParamProcService.getInstance().getIsAce()){
//            // 需要进行账户处理
//            ((AceGenVouDtlService) AceGenVouDtlService.getInstance())
//                    .excute(txnLogId);
//        }
//    }

}
