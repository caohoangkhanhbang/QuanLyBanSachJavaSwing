/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CHKB.DAO;

import CHKB.MODAL.ThanhVien;
import CHKB.MODAL.TheLoai;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author caoho
 */
public class CHKB_ThanhVienManipulation {
     ConnectionToDatabase con = new ConnectionToDatabase();
    
     public List<ThanhVien> getAllData() throws SQLException
    {
        List<ThanhVien> lstData = new ArrayList<>();
        String sql = "{call getAllThanhVien}";
        CallableStatement call = con.getConnection().prepareCall(sql);
        ResultSet rs = call.executeQuery();
        while(rs.next())
        {
            lstData.add(new ThanhVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10)));
        }
        return lstData;
    }

    public CHKB_ThanhVienManipulation() {
    }
    
    public int InsertDeleteUpdate(String sql) throws SQLException
    {
        int result = 0;
        ConnectionToDatabase con = new ConnectionToDatabase();
        con.InsertDeleteUpdate(sql);
        return result;
    }
}
