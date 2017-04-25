package view;
import java.awt.Color;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.NumericField;
import org.uqbar.arena.widgets.Panel;

import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import model.Cuenta;
import viewmodel.ConsultarValorCuentaViewModel;


@SuppressWarnings("serial")

public class ConsultarValorCuenta extends Dialog<ConsultarValorCuentaViewModel>{
	@SuppressWarnings("serial")
	public ConsultarValorCuenta(WindowOwner owner) {
		super(owner, new ConsultarValorCuentaViewModel());
	}

		public void createContents(Panel mainPanel) {
			this.setTitle("Obtener datos de una cuenta");
			mainPanel.setLayout(new VerticalLayout());

			new Label(mainPanel).setText("Numero de cuenta");
			new TextBox(mainPanel).bindValueToProperty("numero_cuenta");
				

			new Button(mainPanel)
				.setCaption("Consultar cuenta")
				.onClick(()->getModelObject().obtenerCuenta());
			
			
			new Label(mainPanel).setText("Datos de la cuenta").setBackground(Color.GREEN);
					
			new Label(mainPanel).setText("Nombre de cuenta");
			new TextBox(mainPanel).bindValueToProperty("nombre_cuenta");
			
			new Label(mainPanel).setText("Numero de cuenta");
			new NumericField(mainPanel).bindValueToProperty("numero_cuenta");
			
			
			//<Cuenta>
			Table<Cuenta> tablaCuentas = new Table<>(mainPanel, Cuenta.class);
			tablaCuentas.bindValueToProperty("unaCuenta");
			tablaCuentas.setNumberVisibleRows(5).bindItemsToProperty("cuentas");
			
			Column<Cuenta> columnaAnio = new Column<Cuenta>(tablaCuentas);
			columnaAnio.setTitle("Año").bindContentsToProperty("anio_cuenta");
			
			/*Column<Cuenta> columnaEbitda = new Column<Cuenta>(tablaCuentas);
			columnaEbitda.setTitle("EBITDA - Earnings Before Interest, Taxes, Depreciation and Amortization");
			//.bindContentsToProperty("...");
			
			Column<Cuenta> columnaFds = new Column<Cuenta>(tablaCuentas);
			columnaFds.setTitle("FDS - Fully Diluted Shares");
			//.bindContentsToProperty("...");
			
			Column<Cuenta> columnaFcf = new Column<Cuenta>(tablaCuentas);
			columnaFcf.setTitle("FCF - Free Cash Flow");
			//.bindContentsToProperty("...");
			
			Column<Cuenta> columnaCo = new Column<Cuenta>(tablaCuentas);
			columnaCo.setTitle("Continuing Operations");
			//.bindContentsToProperty("...");
			
			Column<Cuenta> columnaDo = new Column<Cuenta>(tablaCuentas);
			columnaDo.setTitle("Discontinued Operations ");
			//.bindContentsToProperty("...");
			*/
			
		}
		
		public void consultarValorCuenta(){
			
		}
		
		
		@Override
		protected void addActions(Panel arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		protected void createFormPanel(Panel arg0) {
			// TODO Auto-generated method stub
			
		}
		

}