package afinal.proyecto.controladordifuso;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Fuzzy f;
    private Integer edad = 20;
    private Integer educ = 1;
    private TextView lblNivel;
    private String nivel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lblNivel = (TextView) findViewById(R.id.lblNivel);
        f= new Fuzzy(this);
        nivel = obtenerNivel(edad,educ);
        lblNivel.setText("Nivel Tecnológico: "+ nivel);
    }

    public String obtenerNivel(int edad, int educ){
        String resultado="";
        try {
           double r = f.FuzzyEngine(edad,educ);

            if(r<=1){
                resultado = "Bajo";
                    }else
                        {
                            if(1<r && r<=2){
                                resultado = "Medio";
                                          }else{
                                                if(r>2) {
                                                        resultado = "Alto";
                                                        }else{
                                                            resultado ="No se pudo obtener el nivel";
                                                            }
                                                }
                        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }
}
