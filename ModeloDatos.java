package Logica;

import java.util.HashMap;
import entidades.Estudiante;
import javax.swing.JOptionPane;

public class ModeloDatos {
    private HashMap<String, Estudiante> estudiantesMap;

    public ModeloDatos() {
        estudiantesMap = new HashMap<>();
    }

    public void registrarEstudiante(Estudiante est) {
        estudiantesMap.put(est.getDocumento(), est);
        JOptionPane.showMessageDialog(null, "Registrado con éxito");
    }

    public Estudiante consultarEstudiante(String documento) {
        return estudiantesMap.get(documento);
    }

    public void eliminarEstudiante(String documento) {
        if (estudiantesMap.containsKey(documento)) {
            estudiantesMap.remove(documento);
            JOptionPane.showMessageDialog(null, "Estudiante eliminado");
        } else {
            JOptionPane.showMessageDialog(null, "No existe el estudiante");
        }
    }

    public void actualizarEstudiante(Estudiante est) {
        if (estudiantesMap.containsKey(est.getDocumento())) {
            estudiantesMap.put(est.getDocumento(), est);
            JOptionPane.showMessageDialog(null, "Datos actualizados");
        }
    }

    public HashMap<String, Estudiante> getMap() {
        return estudiantesMap;
    }
}