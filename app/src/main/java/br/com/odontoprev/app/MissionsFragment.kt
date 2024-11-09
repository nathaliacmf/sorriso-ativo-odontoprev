package br.com.odontoprev.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class MissionsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Infla o layout para este fragmento
        val view = inflater.inflate(R.layout.fragment_missions, container, false)

        // Configura o link no botão ">" para a página de "More Missions"
        val moreMissionsButton = view.findViewById<TextView>(R.id.textView21)
        moreMissionsButton.setOnClickListener {
            findNavController().navigate(R.id.action_missionsFragment_to_moreMissionsFragment)
        }

        // Configura o link no texto "Trocar Pontos" para a página de "Trocar Pontos"
        val trocarPontosText = view.findViewById<TextView>(R.id.textView23)
        trocarPontosText.setOnClickListener {
            findNavController().navigate(R.id.action_missionsFragment_to_trocarPontosFragment)
        }

        // Configura o link no botão "Realizar Missão" para a página de "Registrar Foto"
        val realizarMissaoButton = view.findViewById<Button>(R.id.btn_realizar_missao)
        realizarMissaoButton.setOnClickListener {
            findNavController().navigate(R.id.action_missionsFragment_to_registrarFotoFragment)
        }

        // Configura o link no "<" para retornar ao HomeFragment
        val backButton = view.findViewById<TextView>(R.id.textView22)
        backButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_missionsFragment)
        }

        return view
    }
}



