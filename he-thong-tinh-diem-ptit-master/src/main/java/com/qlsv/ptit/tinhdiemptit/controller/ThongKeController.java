package com.qlsv.ptit.tinhdiemptit.controller;

import com.qlsv.ptit.tinhdiemptit.dao.ThongKeDAO;
import com.qlsv.ptit.tinhdiemptit.entity.MonHoc;
import com.qlsv.ptit.tinhdiemptit.entity.NhomMonHoc;
import com.qlsv.ptit.tinhdiemptit.resultobject.DiemSos;
import com.qlsv.ptit.tinhdiemptit.resultobject.MonHocs;
import com.qlsv.ptit.tinhdiemptit.resultobject.SinhVien_Diem;
import com.qlsv.ptit.tinhdiemptit.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/thongke")
public class ThongKeController {

		@Autowired
		private MonHocService monHocService;

		@Autowired
		private ThongKeService thongKeService;

		@Autowired
		private CauHinhDiemService cauHinhDiemService;

		@Autowired
		private SinhVienService sinhVienService;

		@GetMapping(value= {"", "/{maMonHoc}", "/{maMonHoc}/{nhomMonHoc}"})
		public String getListMonHocTheoNhom(Model model, @PathVariable(required = false) String maMonHoc,
											@PathVariable(required = false) Integer nhomMonHoc) {
			List<MonHoc> listMonHoc = monHocService.findMonHocDropDown();
			model.addAttribute("listMonHoc", listMonHoc);
			if (maMonHoc != null) {
				List<NhomMonHoc> listNhomMonHoc = monHocService.findNhomMonHocDropDown(maMonHoc);
				List<MonHocs> listMonHocs = monHocService.findById(maMonHoc, nhomMonHoc);
				String cauHinhDiem = cauHinhDiemService.findById(maMonHoc);
				model.addAttribute("cauHinhDiem", cauHinhDiem);
				model.addAttribute("selectedId", maMonHoc);
				model.addAttribute("listNhomMonHoc", listNhomMonHoc);
				model.addAttribute("listMonHocs", listMonHocs);
				if (nhomMonHoc != null) {
					model.addAttribute("selectedNhom", nhomMonHoc);
				}
			}
			return "/thongke/danhsachmonhoc";
		}

		@GetMapping("/{maMonHoc}/{nhomMonHoc}/dssv")
		public String getListSinhVienTheoNhom(Model model,
											  @PathVariable String maMonHoc,
											  @PathVariable Integer nhomMonHoc,
											  @RequestParam(name = "tenMH", required = false) String tenMH,
											  @RequestParam(name = "giangVien", required = false) String giangVien,
											  @RequestParam(name = "cauHinhDiem", required = false) String cauHinhDiem) {
			int thi = thongKeService.findbytbdiem(maMonHoc,nhomMonHoc).size();
			int tong = sinhVienService.findByNhomMonHoc(maMonHoc, nhomMonHoc).size();

			DiemSos lst = new DiemSos(thongKeService.findbytbdiem(maMonHoc, nhomMonHoc));
			model.addAttribute("thi", thi);
			model.addAttribute("tong", tong);
			model.addAttribute("lst", lst);
			model.addAttribute("nhomMH", nhomMonHoc);
			model.addAttribute("giangVien", giangVien);
			model.addAttribute("tenMH", tenMH);
			model.addAttribute("cauHinhDiem", cauHinhDiem);
			model.addAttribute("maMonHoc", maMonHoc);
			return "/thongke/danhsachsinhvien";
		}


	}


