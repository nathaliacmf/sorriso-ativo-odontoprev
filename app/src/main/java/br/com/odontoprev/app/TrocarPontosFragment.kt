package br.com.odontoprev.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class TrocarPontosFragment : Fragment() {

    private lateinit var progressBarRecompensa: ProgressBar
    private lateinit var progressBarMissao: ProgressBar
    private lateinit var tvProgressoRecompensa: TextView
    private lateinit var tvProgressoMissao: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_trocar_pontos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inicialização dos componentes de UI
        progressBarRecompensa = view.findViewById(R.id.progress_bar_recompensa_trocar)
        progressBarMissao = view.findViewById(R.id.progress_bar_missao_trocar)
        tvProgressoRecompensa = view.findViewById(R.id.tv_proxima_recompensa)
        tvProgressoMissao = view.findViewById(R.id.tv_progresso)

        // Botão para voltar ao MissionsFragment
        val backButton = view.findViewById<TextView>(R.id.textView22)
        backButton.setOnClickListener {
            findNavController().navigate(R.id.action_trocarPontosFragment_to_missionsFragment)
        }

        // Atualiza a barra de progresso da recompensa e missão usando métodos internos
        atualizarProgressoRecompensa()
        atualizarProgressoMissao()
    }

    // Método interno para calcular e exibir o progresso da recompensa
    private fun atualizarProgressoRecompensa() {
        val progressoRecompensa = 60 // Simula o progresso da recompensa (porcentagem)
        val pontosRestantesParaProximaRecompensa = 1250 // Simula os pontos restantes

        progressBarRecompensa.progress = progressoRecompensa
        tvProgressoRecompensa.text = "$pontosRestantesParaProximaRecompensa pontos até a próxima recompensa"
    }

    // Método interno para calcular e exibir o progresso da missão
    private fun atualizarProgressoMissao() {
        val progressoMissaoAtual = 4250 // Simula o progresso atual da missão
        val pontosParaCompletarMissao = 6000 // Simula os pontos totais necessários
        val progressoMissao = (progressoMissaoAtual * 100) / pontosParaCompletarMissao // Calcula a porcentagem

        progressBarMissao.progress = progressoMissao
        tvProgressoMissao.text = "Progresso: $progressoMissaoAtual de $pontosParaCompletarMissao pontos"
    }
}





