package com.hrm.taikhoan.service.qua_trinh_cong_tac;

import com.hrm.taikhoan.dto.client.qua_trinh_cong_tac.QuaTrinhCongTac;
import com.hrm.taikhoan.dto.client.qua_trinh_cong_tac.QuaTrinhCongTacClient;
import com.hrm.taikhoan.dto.client.qua_trinh_cong_tac.ReqQuaTrinhCongTac;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class QuaTrinhCongTacService implements IQuaTrinhCongTacService {
    final QuaTrinhCongTacClient client;

    @Override
    public List<QuaTrinhCongTac> xemDanhSach() {
        return client.getAll();
    }

    @Override
    public QuaTrinhCongTac xemChiTiet(int id) {
        return client.getById(id);
    }

    @Override
    public QuaTrinhCongTac them(UUID id, ReqQuaTrinhCongTac req) {
        return client.add(id, req);
    }

    @Override
    public QuaTrinhCongTac sua(int id, ReqQuaTrinhCongTac req) {
        return client.edit(id, req);
    }

    @Override
    public boolean xoa(int id) {
        return client.del(id);
    }
}
