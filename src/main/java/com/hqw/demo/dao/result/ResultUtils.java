package com.hqw.demo.dao.result;

public class ResultUtils {
    public static Result successResult(Object object){
        Result result = new Result();
        result.setCode(1);
        result.setData(object);
        result.setMsg("操作成功");

        return result;
    }

    public static Result success1Result(){
        return successResult(null);
    }

    public static Result failedresult(String msg,Integer code){
        Result result = new Result();
        result.setCode(code);
        result.setData(null);
        result.setMsg(msg);

        return result;
    }

}
