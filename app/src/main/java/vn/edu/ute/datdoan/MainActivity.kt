package vn.edu.ute.datdoan

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import vn.edu.ute.datdoan.data.DuLieuMau
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
    }
}