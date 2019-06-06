package com.arthur.idc.aspects.audit.aop;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

import com.arthur.idc.aspects.audit.entity.ResOperLog;

@Aspect
public class ResOperLogAspect {

	protected static final SimpleDateFormat Audit_DateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");

	@Autowired
	private ResOperLogGeneratorsHelper resOperLogGeneratorsHelper;

	public void setResOperLogGeneratorsHelper(ResOperLogGeneratorsHelper resOperLogGeneratorsHelper) {
		this.resOperLogGeneratorsHelper = resOperLogGeneratorsHelper;
	}

	/*Pointcouts definitions*/
	@Pointcut("execution(* com.asiainfo.idc.oss.idcipm.service.IIpAddressService.assignIp(..))")
	private void ipAssignLogPointcut() {
	};

	@Pointcut("execution(* com.asiainfo.idc.oss.idcipm.service.IIpAddressService.cancelAssign(..))")
	private void ipReleaseLogPointcut() {
	};

	
//	@Before("")
//	public void before(){
//		
//	}
//	
//	@After("")
//	public void after(){
//		
//	}
//	
//	
//	@AfterReturning("")
//	public void afterReturning(){
//		
//	}
//	
//	@AfterThrowing("")
//	public void afterThrowing(){
//		
//	}
	
	/* Around Advice functional code */
	@Around("ipAssignLogPointcut() || ipReleaseLogPointcut()")
	public Object generateResOperLog(ProceedingJoinPoint jp) {

		Object rtObj = null;

		long operTime = System.currentTimeMillis();
		String operTimeStr = Audit_DateFormat.format(new Date(operTime));
		Object target = jp.getTarget();
		String methodName = jp.getSignature().getName();
		Object[] arguments = jp.getArgs();
		String serviceName = this.getGeneratorName(target, methodName);
		ResOperLogGenerator generator = null;
		// Cann't find log generator, just ignore the log process and do the
		// business logic.
		try {
			generator = resOperLogGeneratorsHelper.getResOperLogGenerator(serviceName);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResOperLog log = null;

		if (generator != null) {
			log = generator.generateLogBeforeInvoke(arguments);
		}

		try {
			rtObj = jp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		if (generator != null) {
			log = generator.wrapLogAfterInvoke(arguments, rtObj, log);
		}

		if (log != null) {
			log.setOperTime(operTime);
			log.setOperTimeStr(operTimeStr);
			log.setOperObj(target.getClass().getName());
			log.setOperMethod(methodName);
			//
			// MessageBean msBean = resOperLogService.addResOperLog(log);
			//
			// if(!MessageBean.OperCode_Success.equals(msBean.getCode())){
			// throw new RuntimeException(msBean.getMessage());
			// }
		}
		return rtObj;
	}

	private String getGeneratorName(Object target, String methodName) {

		String rtName = "";

		Class<?>[] clazzes = target.getClass().getInterfaces();

		Class<?> interfaceClazz = null;
		boolean rightInterface = false;

		try {
			if (clazzes.length == 1) {
				rtName = clazzes[0].getName() + "_" + methodName;
			} else {
				for (Class<?> _interfaceClazz : clazzes) {
					rightInterface = false;
					Method[] methods = _interfaceClazz.getMethods();
					for (Method _method : methods) {
						if (_method.getName().equals(methodName)) {
							rightInterface = true;
							interfaceClazz = _interfaceClazz;
							break;
						}
					}
					if (rightInterface) {
						rtName = interfaceClazz.getName() + "_" + methodName;
						break;
					}
				}
			}

		} catch (Exception e) {
			return rtName;
		}

		return rtName;
	}

}
