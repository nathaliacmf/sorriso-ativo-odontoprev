package br.com.odontoprev.app

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class RegistrarFotoFragment : Fragment() {

    private lateinit var btnEnviarFoto: Button
    private var capturedImage: Bitmap? = null

    // Declarando o ActivityResultLauncher com o tipo explícito Intent
    private lateinit var cameraLauncher: ActivityResultLauncher<Intent>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_registrar_foto, container, false)

        // Configuração do botão "<" para voltar ao MissionsFragment
        val backButton = view.findViewById<TextView>(R.id.textView22)
        backButton.setOnClickListener {
            findNavController().navigate(R.id.action_registrarFotoFragment_to_missionsFragment)
        }

        // Configuração do botão para tirar foto
        val btnTirarFoto = view.findViewById<Button>(R.id.btn_tirar_foto)

        // Inicializando o ActivityResultLauncher para capturar a imagem
        cameraLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == android.app.Activity.RESULT_OK) {
                capturedImage = result.data?.extras?.getString("data") as? Bitmap
            }
        }

        btnTirarFoto.setOnClickListener {
            abrirCamera()
        }

        // Configuração do botão para enviar foto
        btnEnviarFoto = view.findViewById(R.id.btn_enviar_foto)
        btnEnviarFoto.setOnClickListener {
            enviarFoto()
        }

        return view
    }

    // Função para abrir a câmera e capturar a imagem
    private fun abrirCamera() {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        cameraLauncher.launch(cameraIntent)
    }

    // Função para "enviar" a foto (simulando armazenamento e navegação para MoreMissionsFragment)
    private fun enviarFoto() {
        if (capturedImage != null) {
            // Simula o armazenamento da foto
            // Aqui você pode implementar o envio para um servidor, por exemplo

            // Navega diretamente para o MoreMissionsFragment após o envio
            findNavController().navigate(R.id.action_registrarFotoFragment_to_moreMissionsFragment)
        } else {
            // Exibe mensagem de erro se nenhuma foto foi tirada
            Toast.makeText(requireContext(), "Por favor, tire uma foto primeiro.", Toast.LENGTH_SHORT).show()
        }
    }
}




