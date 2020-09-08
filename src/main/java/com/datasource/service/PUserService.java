package com.datasource.service;

import com.datasource.bean.PUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PUserService {
    @Autowired
    @Qualifier("masterJdbcTemplate")
    private JdbcTemplate jdbcTemplateMaster;
    @Autowired
    @Qualifier("slaveJdbcTemplate")
    private JdbcTemplate jdbcTemplateSlave;

    public List<Map<String, Object>> findUser1() {
        List<Map<String, Object>> list = jdbcTemplateMaster.queryForList("select * from p_user");
        return list;
    }

    public List<PUser> findUser2() {
        List<PUser> list = new ArrayList<>();
        jdbcTemplateSlave.query("select * from p_user", new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                PUser user = new PUser();
                user.setId(rs.getLong("id"));
                user.setUserName(rs.getString("userName"));
                user.setParentId(rs.getLong("parentId"));
                user.setCreateBy(rs.getString("createBy"));
                user.setUpdateBy(rs.getString("updateBy"));
                user.setEmail(rs.getString("email"));
                user.setGroupId(rs.getLong("groupId"));
                list.add(user);
            }
        });
        return list;
    }
}
