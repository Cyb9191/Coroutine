package com.example.coroutine3

import android.os.Bundle
import android.text.Editable
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.coroutine3.databinding.FragmentFirstBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    var currentNumb: Int? = null
    var incrementedNumb: Int? = null

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonFirst.setOnClickListener {
            lifecycleScope.launch {
                val firstCheck = checkCurrentNumb(currentNumb,incrementedNumb)
                currentNumb= firstCheck.first
                incrementedNumb=firstCheck.second
                printNum(incrementedNumb)
            }
        }
    }

    fun checkCurrentNumb(numbToCh:Int?, currentPar:Int?): Pair<Int?, Int?> {
        var currentPar2:Int?
        var numbToCh2:Int?
        if  (numbToCh == null || (numbToCh != null && numbToCh != binding.numbInput.getText().toString().toInt()))
         {
            numbToCh2= binding.numbInput.getText().toString().toInt()
            currentPar2=numbToCh2+1
        } else {
            numbToCh2=numbToCh
            currentPar2 = currentPar!! + 1
        }
        return Pair(numbToCh2,currentPar2)
    }
    suspend fun printNum(numToPrint:Int?){
        delay(2000)
        binding.textviewFirst.text="${numToPrint.toString()}"
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}








































































































































































































































































