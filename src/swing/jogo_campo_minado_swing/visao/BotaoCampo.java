package swing.jogo_campo_minado_swing.visao;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import swing.jogo_campo_minado_swing.modelo.Campo;
import swing.jogo_campo_minado_swing.modelo.CampoEvento;
import swing.jogo_campo_minado_swing.modelo.CampoObservador;

@SuppressWarnings("serial")
public class BotaoCampo extends JButton implements CampoObservador, MouseListener {

	private static final Color BG_PADRAO = new Color(184, 184, 184);
	private static final Color BG_MARCAR = new Color(8, 179, 247);
	private static final Color BG_EXPLODIR = new Color(189, 66, 68);
	private static final Color TEXTO_VERDE = new Color(0, 100, 0);

	private Campo campo;

	public BotaoCampo(Campo campo) {
		this.campo = campo;

		setBackground(BG_PADRAO);
		setOpaque(true);
		setBorder(BorderFactory.createBevelBorder(0));

		addMouseListener(this);

		this.campo.registrarObservador(this);
	}

	@Override
	public void eventoOcorreu(Campo campo, CampoEvento evento) {
		switch (evento) {
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

		SwingUtilities.invokeLater(() -> {
			repaint();
			validate();
		});
	}

	private void aplicarEstiloAbrir() {

		setBorder(BorderFactory.createLineBorder(Color.GRAY));
		if (this.campo.isMinado()) {
			setBackground(BG_EXPLODIR);
			return;
		}

		setBackground(BG_PADRAO);

		switch (this.campo.minasNaVizinhanca()) {
		case 1:
			setForeground(TEXTO_VERDE);
			break;
		case 2:
			setForeground(Color.BLUE);
			break;
		case 3:
			setForeground(Color.YELLOW);
			break;
		case 4:
		case 5:
		case 6:
			setForeground(Color.RED);
			break;
		default:
			setForeground(Color.PINK);
		}

		String valor = !this.campo.vizinhancaSegura() ? this.campo.minasNaVizinhanca() + "" : "";
		setText(valor);
	}

	private void aplicarEstiloMarcar() {
		setBackground(BG_MARCAR);
		setForeground(Color.BLACK);
		setText("M");
	}

	private void aplicarEstiloExplodir() {
		setBackground(BG_EXPLODIR);
		setForeground(Color.WHITE);
		setText("X");
	}

	private void aplicarEstiloPadrao() {
		setBorder(BorderFactory.createBevelBorder(0));
		setBackground(BG_PADRAO);
		setText("");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			this.campo.abrir();
		} else {
			this.campo.alternarMarcacao();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
}
