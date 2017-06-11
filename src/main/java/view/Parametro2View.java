package view;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.NumericField;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.RadioSelector;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.model.UserException;

import builder.BuilderIndicador;
import model.Cuenta;
import model.Indicador;
import viewmodel.Parametro2ViewModel;

@SuppressWarnings("serial")
public class Parametro2View extends Dialog<Parametro2ViewModel> {
	public Parametro2View(WindowOwner owner,BuilderIndicador builder) {

		super(owner, new Parametro2ViewModel(builder));
		this.getModelObject().obtenerIndicadores();
		this.getModelObject().obtenerCuentas();
	}
	
	@Override
	public void createContents(Panel mainPanel) {
		this.setTitle("Ingreso de indicadores");
		mainPanel.setLayout(new VerticalLayout());
		
		RadioSelector<String> radioTipo = new RadioSelector<String>(mainPanel);
		radioTipo.bindItemsToProperty("tipoParametros");
		radioTipo.bindValueToProperty("tipoSeleccionado");
		
		new Label(mainPanel).setText("Valor Constante");
		new NumericField(mainPanel).bindValueToProperty("valorParametroConstante");
		new Label(mainPanel).setText("Indicadores");
		
		Selector<Indicador> selectorIndicadores = new Selector<Indicador>(mainPanel);
		selectorIndicadores.bindItemsToProperty("indicadores").adaptWith(Indicador.class, "nombre");
		selectorIndicadores.bindValueToProperty("indicadorSeleccionado");
		
		new Label(mainPanel).setText("Cuentas");
		
		Selector<Cuenta> selectorCuentas = new Selector<Cuenta>(mainPanel);
		selectorCuentas.bindItemsToProperty("cuentas").adaptWith(Cuenta.class, "nombreCuenta");
		selectorCuentas.bindValueToProperty("cuentaSeleccionada");

		new Button(mainPanel).setCaption("Ingresar segundo parametro").onClick(this::ingresar).disableOnError();
		new Button(mainPanel).setCaption("Ingresar indicador").onClick(this::ingresarIndicador).disableOnError();
		
	}
	public void ingresarIndicador(){
		if(this.dosParametrosLlenos()){
			throw new UserException("Seleccione un solo parametro");
		}
		this.getModelObject().ingresarIndicador();
		this.close();
	}
	public void ingresar(){
		if(this.dosParametrosLlenos()){
			throw new UserException("Seleccione un solo parametro");
		}
		this.getModelObject().ingresarParametro();
		BuilderIndicador builder = this.getModelObject().getBuilderIndicador();
		this.close();
		new Operador2View(this, builder).open();
	}

	private boolean dosParametrosLlenos() {
		return getModelObject().getValorParametroConstante() != null 
					&& getModelObject().getIndicadorSeleccionado() != null 
						|| getModelObject().getCuentaSeleccionada() !=null
							&& getModelObject().getIndicadorSeleccionado() != null;

	}
	
	public void espacio(Panel mainPanel){
		new Label(mainPanel);
	}

	@Override
	protected void createFormPanel(Panel arg0) {
		// TODO Auto-generated method stub
		
	}
}