package br.com.odontoprev.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class HomeFragment : Fragment() {

    private var nomeTextView: TextView? = null
    private var protocoloTextView: TextView? = null
    private var nomeCardTextView: TextView? = null
    private var empresaCardTextView: TextView? = null
    private var numeroPlanoTextView: TextView? = null
    private var cnsPlanoTextView: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        nomeTextView = view.findViewById(R.id.nomeTextView_1)
        protocoloTextView = view.findViewById(R.id.protocolTextView)
        nomeCardTextView = view.findViewById(R.id.nomeCardTextView_1)
        empresaCardTextView = view.findViewById(R.id.nomePlanoCardTextView_1)
        numeroPlanoTextView = view.findViewById(R.id.numeroPlanoTextView_1)
        cnsPlanoTextView = view.findViewById(R.id.cnsPlanoTextView_1)

        val sorrisoAtivoButton: View = view.findViewById(R.id.sorrisoAtivoButton)
        sorrisoAtivoButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_missionsFragment)
        }

        return view
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
        println("Nome: $nome, Protocolo: $protocolo, Empresa: $empresa, Número do Plano: $numeroPlano, CNS do Plano: $cnsPlano")
    }

}


