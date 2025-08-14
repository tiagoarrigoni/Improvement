package swingcampominado.visao;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import swingcampominado.modelo.Campo;
import swingcampominado.modelo.CampoEvento;
import swingcampominado.modelo.CampoObservador;

@SuppressWarnings("serial")
public class BotaoCampo extends JButton implements CampoObservador, MouseListener {
	
	private Campo campo;
	private final Color BG_PADRAO = new Color(184, 184,184);
	private final Color BG_MARCAR = new Color(8, 179, 247);
	private final Color BG_EXPLODIR = new Color(189, 66, 68);
	private final Color TEXTO_VERDE = new Color(0, 100, 0);

	public BotaoCampo(Campo campo) {
		this.campo = campo;
		setBackground(BG_PADRAO);
		setBorder(BorderFactory.createBevelBorder(0));
		
		addMouseListener(this);
		campo.registrarObservador(this);

	}

	@Override
	public void eventoOcorreu(Campo campo, CampoEvento e) {
		switch (e) {
		case ABRIR:
			aplicarEstiloAbrir();
			break;
		case MARCAR:
			aplicarEstiloMarcar();
			break;
		case EXPLODIR:
			aplicarEstiloExplodir();
			break;
		default:
			aplicarEstiloPadrao();
		}

	}

	private void aplicarEstiloPadrao() {
		// TODO Auto-generated method stub
		
	}

	private void aplicarEstiloExplodir() {
		// TODO Auto-generated method stub
		
	}

	private void aplicarEstiloMarcar() {
		// TODO Auto-generated method stub
		
	}

	private void aplicarEstiloAbrir() {
		setBackground(BG_PADRAO);
		setBorder(BorderFactory.createLineBorder(Color.gray));

	}
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == 1) {
			campo.abrir();
		} else {
			campo.altenarMarcacao();
		}
		
	}
	
	public void mouseClicked(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}

	
	
}
