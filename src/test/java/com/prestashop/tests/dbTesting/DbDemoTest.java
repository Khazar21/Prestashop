package com.prestashop.tests.dbTesting;

import com.prestashop.utilities.DbUtils;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class DbDemoTest extends DbUtils {
    @Test
    public void test() throws SQLException {
        setQuery("SELECT * FROM employees");
        List<Map<String,Object>> list= getDataList();
        System.out.println(list);

        close();
    }
}
