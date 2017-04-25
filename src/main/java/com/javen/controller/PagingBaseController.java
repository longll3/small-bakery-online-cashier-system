package com.javen.controller;  
  
import com.javen.common.HttpConstants;  
import com.javen.json.JsonDateValueProcessor;  
  
import net.sf.json.JSONArray;  
import net.sf.json.JSONObject;  
import net.sf.json.JsonConfig;  
  
import org.slf4j.Logger;  
import org.slf4j.LoggerFactory;  
  
import java.util.Date;  
  
/** 
 * Controller���� 
 */  
public class PagingBaseController {  
  
    protected Logger logger = LoggerFactory.getLogger(this.getClass());  
    //final �޷��ı�
    protected final static String DATE_FORMATE = "yyyy-MM-dd";  
      
    /** 
     * ���ط���˴����� 
     * @param obj ������������ 
     * @return �����������ǰ��JSON��ʽ���� 
     * @author long liling 
     * @since 2017-4-2 
     */  
    public String responseResult(Object obj){  
        JSONObject jsonObj = null;  
        if(obj != null){  
            logger.info("jilei responsResult ��˷��ض���{}", obj);  
            JsonConfig jsonConfig = new JsonConfig();   
            jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());  
            jsonObj = JSONObject.fromObject(obj, jsonConfig);  
            logger.info("jilei responsResult ��˷������ݣ�" + jsonObj);  
            if(HttpConstants.SERVICE_RESPONSE_SUCCESS_CODE.equals(jsonObj.getString(HttpConstants.SERVICE_RESPONSE_RESULT_FLAG))){  
                jsonObj.element(HttpConstants.RESPONSE_RESULT_FLAG_ISERROR, false);  
                jsonObj.element(HttpConstants.SERVICE_RESPONSE_RESULT_MSG, "");  
            }else{  
                jsonObj.element(HttpConstants.RESPONSE_RESULT_FLAG_ISERROR, true);  
                String errMsg = jsonObj.getString(HttpConstants.SERVICE_RESPONSE_RESULT_MSG);  
                jsonObj.element(HttpConstants.SERVICE_RESPONSE_RESULT_MSG, errMsg==null?HttpConstants.SERVICE_RESPONSE_NULL:errMsg);  
            }  
        }  
        logger.info("jilei responsResult ��������{}", jsonObj.toString());  
        return jsonObj.toString();  
    }  
      
    /** 
     * ���سɹ� 
     * @param obj ������� 
     * @return ����ɹ���JSON��ʽ���� 
     */  
    public String responseSuccess(Object obj){  
        JSONObject jsonObj = null;  
        if(obj != null){  
            logger.info("jilei responsSuccess ��˷��ض���{}", obj);  
            JsonConfig jsonConfig = new JsonConfig();   
            jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());  
            jsonObj = JSONObject.fromObject(obj, jsonConfig);  
            logger.info("jilei responsSuccess ��˷������ݣ�" + jsonObj);  
            jsonObj.element(HttpConstants.RESPONSE_RESULT_FLAG_ISERROR, false);  
            jsonObj.element(HttpConstants.SERVICE_RESPONSE_RESULT_MSG, "");  
        }  
        logger.info("jilei responsSuccess ��������{}", jsonObj.toString());  
        return jsonObj.toString();  
    }  
  
    /** 
     * ���سɹ� 
     * @param obj ������� 
     * @return ����ɹ���JSON��ʽ���� 
     */  
    public String responseArraySuccess(Object obj){  
        JSONArray jsonObj = null;  
        if(obj != null){  
            logger.info("jilei responsArraySuccess ��˷��ض���{}", obj);  
            JsonConfig jsonConfig = new JsonConfig();  
            jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());  
            jsonObj = JSONArray.fromObject(obj, jsonConfig);  
            logger.info("jilei responsArraySuccess ��˷������ݣ�" + jsonObj);  
        }  
        logger.info("jilei responsArraySuccess ��������{}", jsonObj.toString());  
        return jsonObj.toString();  
    }  
      
    /** 
     * ���سɹ� 
     * @param obj ������� 
     * @return ����ɹ���JSON��ʽ���� 
     */  
    public String responseSuccess(Object obj, String msg){  
        JSONObject jsonObj = null;  
        if(obj != null){  
            logger.info("jilei responsSuccess 2 prams ��˷��ض���{}", obj);  
            JsonConfig jsonConfig = new JsonConfig();   
            jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());  
            jsonObj = JSONObject.fromObject(obj, jsonConfig);  
            logger.info("jilei responsSuccess 2 prams ��˷������ݣ�" + jsonObj);  
            jsonObj.element(HttpConstants.RESPONSE_RESULT_FLAG_ISERROR, false);  
            jsonObj.element(HttpConstants.SERVICE_RESPONSE_RESULT_MSG, msg);  
        }  
        logger.info("jilei responsSuccess 2 prams ��������{}", jsonObj.toString());  
        return jsonObj.toString();  
    }  
      
    /** 
     * ����ʧ�� 
     * @param errorMsg ������Ϣ 
     * @return ���ʧ�ܵ�JSON��ʽ���� 
     */  
    public String responseFail(String errorMsg){  
        JSONObject jsonObj = new JSONObject();  
        jsonObj.put(HttpConstants.RESPONSE_RESULT_FLAG_ISERROR, true);  
        jsonObj.put(HttpConstants.SERVICE_RESPONSE_RESULT_MSG, errorMsg);  
        logger.info("jilei responsFail ��������{}", jsonObj.toString());  
        return jsonObj.toString();  
    }  
  
}  