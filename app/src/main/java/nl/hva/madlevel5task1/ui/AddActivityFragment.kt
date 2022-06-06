package nl.hva.madlevel5task1.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.madlevel5task1.R
import com.example.madlevel5task1.databinding.FragmentAddActivityBinding
import com.google.android.material.datepicker.MaterialDatePicker.Builder.datePicker
import nl.hva.madlevel5task1.model.Game
import nl.hva.madlevel5task1.vm.GameViewModel
import java.time.LocalDate
import java.util.*


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class AddActivityFragment : Fragment() {

    private val viewModel: GameViewModel by viewModels()
    private var _binding: FragmentAddActivityBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAddActivityBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fabSave.setOnClickListener {
            saveGame()
        }

    }

    private fun saveGame() {
        //check title
        if (binding.tilNoteTitle.editText?.text.toString().trim().isEmpty()) {
            Toast.makeText(activity, "Title must be filled.", Toast.LENGTH_SHORT).show()
            return
        }
        //check platform
        if (binding.tilPlatformText.editText?.text.toString().trim().isEmpty()) {
            Toast.makeText(activity, "Platform must be filled", Toast.LENGTH_SHORT).show()
            return
        }

        val day: Int = binding.datePicker1.dayOfMonth
        val month: Int = binding.datePicker1.month
        val year: Int = binding.datePicker1.year

        val calendar = Calendar.getInstance()
        calendar[year, month] = day

        viewModel.insertGame(
            Game(
                binding.tilNoteTitle.editText?.text.toString(),
                calendar.time,
                binding.tilPlatformText.editText?.text.toString()
            )
        )

        //Return to previous view
        view?.findNavController()?.popBackStack();
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}