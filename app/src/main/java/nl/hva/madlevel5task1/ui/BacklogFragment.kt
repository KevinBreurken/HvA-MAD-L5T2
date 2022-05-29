package nl.hva.madlevel5task1.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.madlevel5task1.R
import com.example.madlevel5task1.databinding.FragmentBacklogBinding
import nl.hva.madlevel5task1.vm.GameViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class BacklogFragment : Fragment() {

    private val viewModel: GameViewModel by viewModels()
    private var _binding: FragmentBacklogBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentBacklogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fabAdd.setOnClickListener {
            view.findNavController().navigate(
                R.id.action_notepadFragment_to_addNoteFragment
            )
        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}