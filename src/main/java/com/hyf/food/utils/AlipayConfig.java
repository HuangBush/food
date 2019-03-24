package com.hyf.food.utils;

public class AlipayConfig {
	// 商户appid
	public static String APPID = "2016092700610065";
	// 私钥 pkcs8格式的
	public static String RSA_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDjv8e3+ZgBsX/WXUhKaO8GyBB0grg27T7y2vlTLudPv59gZZt3XFO/egcZ2WfNAtB64fww80QP5eVrtgtKttGuSLuRyptuoN5YRVtawLXYU/PBQXoxUBA8pZqJ4md5N7mOSS67islSz2JNCL2TlcieHvlu1dwd4b57AnbuDaJKFJq95Eh0U/JqFGMAfjZ+7r0Rl4utnpNsohKCCGhlusBSCuPvbzj4mFBso3DqPh/4nhLMVdKz4XfT+0OgOybDjsRnc118pHrrpC7uMNHfG7Lm00FygCpbd4z7mgxV3CyxzzDlTnC2wEWxyd8UcZoB1hTdEOk1xv2WJ5b0wB8eBv25AgMBAAECggEBAJus0pqZ3GKD7ssbdjeOpJwxErZhSAQbhSTBsx09+VTUud9NdMhQ7tn6UnJD3iUPYGwunpDjJ8nqLjjC9dL7RjZodvX/1OD4yyLxPbG5+lLFh9+4nwqoHIEn/Yt0m6ALDCYLNgtxoY2ePiZD7Dm+b6RNrdgqDMzMKsSweZTc8urJAmWyFwIkHqf6JNdeICPMjSYd1IZFhc9NKOrf4mIpFu+J+Y3/nQtzvtvWHTXGGMzITHAhLrDWxEN7glmFrFZAXJEZBNlEQ9t0e1p1RhcJkf2JlZ6Rp+0OcHUV94u5rxYdVCzeHaA9pbKe2K+S3EHtmW6MeEMf5g4qrDeVnWzHGqUCgYEA+yUrzTeGXy5GI1qSkR3ywjAzbuLADg7AW/LvTaA5vHqlFVAWMNmVG7c0Vbgam6r8Y0vdRuAsKVkHj+qDEmzCXQPfK2y/lIbgO24zK2CzLh86dQgAFcd5+x5JweTyJ6OJBHy3216DOz3qAypWxP6pGEk/EOM3ph1f4+5PsQVcimcCgYEA6CbUiVEvv6LTO5xTZJYcD/yR9SS84ktAhiCA0wd//dTpjXPYxX5SrZIVTkBX+WRLnxNPu6oTAme6p0ZIa92HeX2MeDmjnuBKsVX8A0lrCHB2R/AM8DwETe/cbBorfPHndPdxHAakkW/yA0ZTM9k5pH8Tdj/q8mECNDKzQ1e5Yt8CgYEA+svl7+tw7n/hXtDF6NEFadKEqkkaDW/BvJDfVJ+ayJOZY600W9gMxT6wrqFJQQcBP4+1C2A1+ZyEpr1D4xRlDEofhNf2gTYnmnGz+693f6mD0PcKTrWDJLjcYxpkkB0JaUe6uwCpAHIVzM9tExBUgII0zoJ5QhO3fICxaE+4WCUCgYBdlYGqFVtNQmMqrZsEemq3mxZvny6xfqp1J1cnOufCuHip+CBThNfpdnE2SUPtmhvN9af3u9jL6GrbEb8SFIyPUig1Mu8dlccmc8YSwR7vmP5lg4SDt334uQ+/WFFdndqzUSh8psTiiCEkZs4VoaTWBhAfZCbfLHIJ/sI7DHsEOwKBgBtQdWmPZX45Hyk1xSSNcHwxBVAlH2iOAEEQnUPkH0suZvYcUxdnuWbHbIjyp0mvzvCFap7EMnIIirhiXI8x+duix9DY+t6uS+XyETgyJ6wm6kFAQNkn8D8MgOjHFvfZc0uQJeX9e7g72D/KEjg6gKzKOJf85mEHKMYrafqhpSXy";

	// 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://192.168.43.112:8082/food/client/notify_url.jsp";
	// 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
	//"http://192.168.1.108:8082/food/returnMsg.action"    192.168.43.112
	public static String return_url = "http://192.168.43.112:8082/food/returnMsg.do";
	// 请求网关地址
	public static String URL = "https://openapi.alipaydev.com/gateway.do";
	// 编码
	public static String CHARSET = "UTF-8";
	// 返回格式
	public static String FORMAT = "json";
	// 支付宝公钥
	public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA1Cq8PRsv4oGLawqO6N1+zebiRypD6ojzuE/n+atfZlW4zV3Cdst1mbg61SkrWZBlG2AlsFQJh922KZtQWNXDhOToRYTbKcI/8BwbwqCjQQ86LBfIRRcXYWEM/uAP1iv32YnthM7y5Ot+yK8oWBGr5FXcr4kre6/pdDrYa+utDkdyBUAV0b7LJTfs9eYjjeiLMiPezwkFsTsCyQ4EXx8MiWYbLsTrn2//Fq9qNaY6+WOxRta//eqN+Bbw20So0N40SxaV51cMEGC1owUQ0S62ZgfodDIqhnySpuzzjPeAUfsHUb9e460KzIIvzihGd1p7wlm65Kq+uZSi8o4H6Gzm+wIDAQAB";
	// 日志记录目录
	public static String log_path = "/log";
	// RSA2
	public static String SIGNTYPE = "RSA2";

	/*商家账号ekogwe9717@sandbox.com
	商户UID2088102177540821
	登录密码111111
	账户余额
	4115.12充值
	
	买家账号aebsnw6094@sandbox.com
	登录密码111111
	支付密码111111
	用户名称沙箱环境
	证件类型身份证(IDENTITY_CARD)
	证件号码496266190205272619
	账户余额
	95859.00充值*/
}
