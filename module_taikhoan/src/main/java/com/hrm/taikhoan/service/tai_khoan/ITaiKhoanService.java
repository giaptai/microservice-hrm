package com.hrm.taikhoan.service.tai_khoan;


import com.hrm.taikhoan.dto.request.ReqTaiKhoan;
import com.hrm.taikhoan.dto.request.ReqTaiKhoanLogin;
import com.hrm.taikhoan.dto.resopnse.ResAuth;
import com.hrm.taikhoan.dto.resopnse.ResTaiKhoanLogin;
import com.hrm.taikhoan.models.TaiKhoan;

import java.text.Normalizer;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface ITaiKhoanService {
    TaiKhoan xemThongTin();

    boolean doiMatKhau(String matkhau);

    boolean doiEmail(String email);

    List<TaiKhoan> xemDanhSachTaiKhoan(); //admin

    TaiKhoan xemTheoSoCCCDOrUsername(String soCCCD); //admin user

    TaiKhoan xemTheoId(int id); //admin user

    TaiKhoan them(ReqTaiKhoan taiKhoan);

    ResTaiKhoanLogin dangNhap(ReqTaiKhoanLogin reqTaiKhoanLogin);
    ResAuth dangNhap0(ReqTaiKhoanLogin login);

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
        int checkUsername = taiKhoans.stream().filter(tKhoan -> tKhoan.getUsername().contentEquals(newS)).toList().size();
        if (checkUsername > 0) {
            newS.append(checkUsername);
        }
        return newS.toString();
    }
}
