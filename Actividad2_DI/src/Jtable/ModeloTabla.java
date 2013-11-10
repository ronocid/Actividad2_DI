
package Jtable;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModeloTabla extends AbstractTableModel{
    ArrayList datos=new ArrayList ();
    String [] nombreCol=new String []{"Nombre","Apellidos","Edad","Deporte","Localidad"};
    Class[] type=new Class[]{java.lang.String.class,java.lang.String.class,java.lang.Integer.class,java.lang.String.class,java.lang.String.class};
    
    public ModeloTabla(ArrayList list){
        this.datos=list;
    }
    
    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return nombreCol.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object[]elemento=(Object[]) datos.get(rowIndex);
        return  elemento[columnIndex];
    }
    
    public String getColumnName(int col){
        return nombreCol[col];
    }
    
    public Class getColumnClass(int col){
        return type[col];
    }
    
    public void setValueAt(Object elemento,int row,int col){
        Object[]fila=(Object[]) datos.get(row);
        fila[col]=elemento;
        fireTableCellUpdated(row,col);
    }
    
    public void anadirFila(Object [] fila){
        datos.add(fila);
        fireTableDataChanged();
    }
    
    public void borrarFila(int fila){
        datos.remove(fila);
        fireTableDataChanged();
    }
    
    public boolean inCellEditable(int row, int col){
        boolean editable;
        if(col==nombreCol.length-1)
            editable=true;
        else
            editable=false;

        return editable;
    }
}
