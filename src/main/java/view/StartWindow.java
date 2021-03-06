package view;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import builder.BuilderIndicador;
import builder.BuilderMetodologia;
import viewmodel.StartWindowViewModel;

@SuppressWarnings("serial")
public class StartWindow extends SimpleWindow<StartWindowViewModel> {

	public StartWindow(WindowOwner parent) {
		super(parent, new StartWindowViewModel());
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createContents(Panel mainPanel) {
		this.setTitle("Pantalla de administracion de cuentas");
		mainPanel.setLayout(new VerticalLayout());

		new Button(mainPanel).setCaption("Consultar Cuenta").onClick(
				this::consultarCuenta);
		new Button(mainPanel).setCaption("Ingresar indicadores").onClick(
				this::ingresarIndicadores);
		new Button(mainPanel).setCaption("Ingresar metodologia").onClick(
				this::ingresarMetodologia);
		new Button(mainPanel).setCaption("Ejecutar metodologia").onClick(
				this::ejecutarMetodologia);
	}
	
	public void ejecutarMetodologia(){
		new EjecutarMetodologiaView(this).open();
	}
	public void ingresarMetodologia(){
		BuilderMetodologia builder = new BuilderMetodologia();
		new IngresarMetodologiaView(this, builder).open();
	}
	public void consultarCuenta() {
		new ConsultarValorCuenta(this).open();
	}
	
	public void ingresarIndicadores() {
		BuilderIndicador builder = new BuilderIndicador();
		new Parametro1View(this,builder, null).open();
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
