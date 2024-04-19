package com.hrm.taikhoan.service;

import com.hrm.taikhoan.dto.request.ReqTaiKhoan;
import com.hrm.taikhoan.dto.request.ReqTaiKhoanLogin;
import com.hrm.taikhoan.dto.resopnse.ResTaiKhoan;
import com.hrm.taikhoan.dto.resopnse.ResTaiKhoanLogin;
import com.hrm.taikhoan.enums.RoleTaiKhoan;
import com.hrm.taikhoan.models.TaiKhoan;

import java.text.Normalizer;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface ITaiKhoanService {
    ResTaiKhoan xemTaiKhoanCaNhan(int id);

    boolean doiMatKhauTaiKhoanCaNhan(int id, String matkhau);

    boolean doiEmailTaiKhoanCaNhan(int id, String email);

    List<ResTaiKhoan> xemDanhSachTaiKhoan(String username, RoleTaiKhoan role, int pageNumber, int pageSize); //admin

    List<ResTaiKhoan> xemTheoUsername(String username, int pageNumber, int pageSize); //admin user

    ResTaiKhoan xemTheoId(int id); //admin user

    ResTaiKhoan them(ReqTaiKhoan taiKhoan);

    ResTaiKhoanLogin dangNhap(ReqTaiKhoanLogin login);

    static boolean checkMatKhau(String matkhau) {
        Pattern pattern = Pattern.compile("^[\\p{Lower}\\p{Upper}\\d\\S]{6,15}$");
        Matcher matcher = pattern.matcher(matkhau);
        return matcher.matches();
    }

    static String createUsername(String hoVaTen, List<TaiKhoan> taiKhoans) {
        String temp = Normalizer.normalize(hoVaTen, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        hoVaTen = pattern.matcher(temp).replaceAll("").replace('đ', 'd').replace('Đ', 'D');
        String[] sSplit = hoVaTen.split(" "); // tách chuỗi
        StringBuffer newS = new StringBuffer(); // tạo 1 chuỗi mới
        //lay tu cuoi, chu dau in hoa con lai viet thuong
        if (sSplit.length > 0) {
            for (int i = 0; i < sSplit[sSplit.length - 1].length(); i++) {
                if (i != 0) {
                    newS.append(Character.toLowerCase(sSplit[sSplit.length - 1].charAt(i)));
                    continue;
                }
                newS.append(sSplit[sSplit.length - 1].charAt(i));
            }
        }
        //lay nhung chu cai dau
        for (int i = 0; i < sSplit.length - 1; i++) {
            newS.append(sSplit[i].charAt(0));
        }
        int checkUsername = taiKhoans.stream().filter(tKhoan -> tKhoan.getUsername().contains(newS)).toList().size();
        if (checkUsername > 0) {
            newS.append(checkUsername);
        }
        return newS.toString();
    }
}
