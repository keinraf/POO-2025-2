package pe.edu.upeu.calcfx.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;
import org.springframework.stereotype.Controller;

@Controller
public class CalcfxControl {

    private final ProjectInfoProperties projectInfoProperties;
    @FXML
    private TextField txtResultado;

    public CalcfxControl(ProjectInfoProperties projectInfoProperties) {
        this.projectInfoProperties = projectInfoProperties;
    }

    private void escribirNumero(String numero) {
        txtResultado.appendText(numero);
    }

    private void agregarOperador(String operador) {
        if(!txtResultado.getText().isEmpty() && txtResultado.getText().length()>=4){
            char op = txtResultado.getText().charAt(txtResultado.getText().length()-2);
            if(txtResultado.getText().toString().contentEquals(String.valueOf(op))){
                txtResultado.appendText(" " + operador + " ");
            }
        }else{
            txtResultado.appendText(" " + operador + " ");
        }
    }

    private void calcularResultado() {

    }


    @FXML
    private void controlClick(ActionEvent event) {
        Button boton = (Button) event.getSource();
       switch (boton.getId()){
           case "btn0", "btn1","btn2","btn3", "btn4", "btn5", "btn6", "btn7", "btn8", "btn9": {escribirNumero(boton.getText());}break;
           case "btnDiv", "btnMult","btnRest", "btnSum", "btnPot", "btnRaiz", "btnSobre", "btnPi", "btnBinario":{ agregarOperador(boton.getText()); }break;
           case "btnBorrar":{ txtResultado.setText(""); }break;
           case "btnIgual":{  calcularResultado();  }break;
           default: {} break;
       }
    }

}
