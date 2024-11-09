package br.com.odontoprev.app

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Gerenciar insets para layout edge-to-edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Verifique se o HomeFragment já está carregado
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                replace(R.id.fragment_container, HomeFragment())
            }
        }

        // Função para acessar o HomeFragment e atualizar as informações
        fun updateHomeFragmentInfo(
            nome: String = "Nathalia Comeron Freire",
            protocolo: String = "1234567890",
            empresa: String = "Empresa XYZ",
            numeroPlano: String = "00000000012345",
            cnsPlano: String = "000000000123456"
        ) {
            // Verifique se o fragmento atual é o HomeFragment e o atualize
            val homeFragment = supportFragmentManager.findFragmentById(R.id.fragment_container) as? HomeFragment

            // Certifique-se de que todos os parâmetros necessários estão sendo passados para updateInfo()
            homeFragment?.updateInfo(nome, protocolo, empresa, numeroPlano, cnsPlano)
        }




    }

    // Em HomeFragment
    fun updateInfo(
        nome: String,
        protocolo: String,
        empresa: String,
        numeroPlano: String,
        cnsPlano: String
    ) {
        // Lógica para atualizar as informações no fragmento
        // Aqui você pode, por exemplo, atualizar TextViews com esses valores
        println("Nome: $nome, Protocolo: $protocolo, Empresa: $empresa, Número do Plano: $numeroPlano, CNS do Plano: $cnsPlano")
    }
}

