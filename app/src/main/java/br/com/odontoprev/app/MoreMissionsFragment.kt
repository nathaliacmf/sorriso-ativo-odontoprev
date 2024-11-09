package br.com.odontoprev.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class MoreMissionsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar o layout para este fragmento
        val view = inflater.inflate(R.layout.fragment_more_missions, container, false)

        // Configuração para voltar ao `homeFragment` ao clicar no "<"
        val backButton: TextView = view.findViewById(R.id.textView22)
        backButton.setOnClickListener {
            findNavController().navigate(R.id.action_moreMissionsFragment_to_homeFragment)
        }

        // Configuração para navegar para `registrarFotoFragment` ao clicar em "Realizar Missão"
        val realizarMissaoButton: Button = view.findViewById(R.id.btn_realizar_missao)
        realizarMissaoButton.setOnClickListener {
            findNavController().navigate(R.id.action_moreMissionsFragment_to_registrarFotoFragment)
        }

        return view
    }
}
