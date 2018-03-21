package com.example.mobilego.util.response;

import com.example.mobilego.constant.ResultStatus;

/**
 * @author： ygl
 * @date： 2018/3/21-11:05
 * @Description：
 */
public class ResultHelper {

    public static Result ok(){
        Result result = new Result();
        result.setCode(ResultStatus.OK.getCode());
        result.setMsg(ResultStatus.OK.getMsg());
        return result;
    }

    public static Result ok(Object data){
        Result result = new Result();
        result.setCode(ResultStatus.OK.getCode());
        result.setMsg(ResultStatus.OK.getMsg());
        result.setData(data);
        return result;
    }

    public static Result error(){
        Result result = new Result();
        result.setCode(ResultStatus.ERROR.getCode());
        result.setMsg(ResultStatus.ERROR.getMsg());
        return result;
    }

    public static Result error(Object data){
        Result result = new Result();
        result.setCode(ResultStatus.ERROR.getCode());
        result.setMsg(ResultStatus.ERROR.getMsg());
        result.setData(data);
        return result;
    }

}
