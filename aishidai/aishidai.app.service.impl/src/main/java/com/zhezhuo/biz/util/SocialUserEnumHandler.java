package com.zhezhuo.biz.util;

/**
 * Created by Shaka on 15/4/5.
 */
import java.sql.SQLException;
import java.sql.Types;

import com.ibatis.sqlmap.client.extensions.ParameterSetter;
import com.ibatis.sqlmap.client.extensions.ResultGetter;
import com.ibatis.sqlmap.client.extensions.TypeHandlerCallback;
import com.zhezhuo.model.SocialUserEnum;

public class SocialUserEnumHandler implements TypeHandlerCallback {

    public Object getResult(ResultGetter getter) throws SQLException {
        SocialUserEnum result = null;
        if(!getter.wasNull() /*&& getter.getObject()!= null*/) {
            for(SocialUserEnum status : SocialUserEnum.values()) {
                if(status.getId() == getter.getInt()/*getter.getObject()*/) {
                    result = status;
                    break;
                }
            }
        }
        return result;
    }

    public void setParameter(ParameterSetter setter, Object obj)
            throws SQLException {
        if(obj == null) {
            setter.setInt(Types.INTEGER);
        }else {
            SocialUserEnum status = (SocialUserEnum)obj;
            setter.setInt(status.getId());
        }
    }

    public Object valueOf(String s) {
        return s;
    }

}
