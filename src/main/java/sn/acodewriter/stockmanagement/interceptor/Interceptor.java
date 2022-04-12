package sn.acodewriter.stockmanagement.interceptor;

import org.hibernate.EmptyInterceptor;
import org.springframework.util.StringUtils;

public class Interceptor extends EmptyInterceptor {

    @Override
    public String onPrepareStatement(String sql) {
        if (StringUtils.hasLength(sql) && sql.toLowerCase().startsWith("select")){
            if (sql.contains("where")){
                sql += " and company_id = 1";
            }else {
                sql += " where company_id = 1";
            }
        }
        return super.onPrepareStatement(sql);
    }
}
