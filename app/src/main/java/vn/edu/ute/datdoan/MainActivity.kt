package vn.edu.ute.datdoan

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.doAfterTextChanged
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import vn.edu.ute.datdoan.data.DuLieuMau
import vn.edu.ute.datdoan.helper.DatMonHelper
import vn.edu.ute.datdoan.helper.KiemTraHelper
import vn.edu.ute.datdoan.model.MonAn

class MainActivity : AppCompatActivity() {
    lateinit var tilhoten: TextInputLayout
    lateinit var tilsdt: TextInputLayout
    lateinit var tildiachi: TextInputLayout
    lateinit var tilsoluong: TextInputLayout
    lateinit var tilkhoangcach: TextInputLayout

    lateinit var edthoten: TextInputEditText
    lateinit var edtsdt: TextInputEditText
    lateinit var edtdiachi: TextInputEditText
    lateinit var edtsoluong: TextInputEditText
    lateinit var edtkhoangcach: TextInputEditText

    lateinit var txtmonan: TextView
    lateinit var txttamtinh: TextView
    lateinit var btndatmon: Button

    var monchon: MonAn = DuLieuMau.dsMonAn[0]

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tilhoten = findViewById(R.id.tilhoten)
        tilsdt = findViewById(R.id.tilsdt)
        tildiachi = findViewById(R.id.tildiachi)
        tilsoluong = findViewById(R.id.tilsoluong)
        tilkhoangcach = findViewById(R.id.tilkhoangcach)

        edthoten = findViewById(R.id.edthoten)
        edtsdt = findViewById(R.id.edtsdt)
        edtdiachi = findViewById(R.id.edtdiachi)
        edtsoluong = findViewById(R.id.edtsoluong)
        edtkhoangcach = findViewById(R.id.edtkhoangcach)

        txtmonan = findViewById(R.id.txtmonan)
        txttamtinh = findViewById(R.id.txttamtinh)
        btndatmon = findViewById(R.id.btndatmon)

        txtmonan.text = "${monchon.ten} - Giá: ${monchon.donGia}"

        edtsoluong.doAfterTextChanged { capnhatui() }
        edtkhoangcach.doAfterTextChanged { capnhatui() }
        btndatmon.setOnClickListener { xulydatmon() }
    }
    fun capnhatui() {
        txtmonan.text = "${monchon.ten} - Giá: ${monchon.donGia}"
        val sl = edtsoluong.text.toString().trim().toIntOrNull() ?: 0
        val kc = edtkhoangcach.text.toString().trim().toIntOrNull() ?: 0
        val tien = DatMonHelper.tinhTienDon_23115053122139(monchon, sl, kc)
        txttamtinh.text = "Tạm tính: $tien"
    }
    fun xulydatmon() {
        val hoten = edthoten.text.toString().trim()
        val sdt = edtsdt.text.toString().trim()
        val diachi = edtdiachi.text.toString().trim()
        val sl = edtsoluong.text.toString().trim().toIntOrNull()
        val kc = edtkhoangcach.text.toString().trim().toIntOrNull()

        tilhoten.error = if (KiemTraHelper.kiemTraHoTen(hoten)) null else "Sai ho ten"
        tilsdt.error = if (KiemTraHelper.kiemTraSdt(sdt)) null else "Sai SDT"
        tildiachi.error = if (KiemTraHelper.kiemTraDiaChi(diachi)) null else "Dia chi >= 5 ky tu"
        tilsoluong.error = if (sl != null && DatMonHelper.hopLeSoLuong(monchon, sl)) null else "Sai so luong"
        tilkhoangcach.error = if (kc != null && kc in 1..25) null else "Khoang cach 1-25km"

        if (listOf(tilhoten, tilsdt, tildiachi, tilsoluong, tilkhoangcach).any { it.error != null }) {
            Snackbar.make(btndatmon, "Vui lòng kiểm tra lại thông tin", Snackbar.LENGTH_SHORT).show()
            return
        }
        Toast.makeText(this, "Đã ghi nhận đơn của $hoten", Toast.LENGTH_SHORT).show()
    }
}