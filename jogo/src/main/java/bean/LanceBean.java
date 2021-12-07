package bean;

import java.util.List;
import java.util.Random;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import dao.LanceDAO;
import domain.Lance;

@ManagedBean
public class LanceBean {

	private Lance lance = new Lance();

	private List<Lance> lances;

	private Integer numero1 = 0;
	private Integer numero2 = 0;
	private Integer numero3 = 0;
	private Integer numero4 = 0;
	private Integer numero5 = 0;

	public void quantitativo() {
		this.numero1 = 0;
		this.numero2 = 0;
		this.numero3 = 0;
		this.numero4 = 0;
		this.numero5 = 0;

		for (Lance c : LanceDAO.listar()) {

			if (c.getV1() == 1) {
				this.numero1 = numero1 + 1;
			}
			if (c.getV2() == 1) {
				this.numero1 = numero1 + 1;
			}
			if (c.getV3() == 1) {
				this.numero1 = numero1 + 1;
			}

			if (c.getV1() == 2) {
				this.numero2 = numero2 + 1;
			}
			if (c.getV2() == 2) {
				this.numero2 = numero2 + 1;
			}
			if (c.getV3() == 2) {
				this.numero2 = numero2 + 1;
			}

			if (c.getV1() == 3) {
				this.numero3 = numero3 + 1;
			}
			if (c.getV2() == 3) {
				this.numero3 = numero3 + 1;
			}
			if (c.getV3() == 3) {
				this.numero3 = numero3 + 1;
			}

			if (c.getV1() == 4) {
				this.numero4 = numero4 + 1;
			}
			if (c.getV2() == 4) {
				this.numero4 = numero4 + 1;
			}
			if (c.getV3() == 4) {
				this.numero4 = numero4 + 1;
			}

			if (c.getV1() == 5) {
				this.numero5 = numero5 + 1;
			}
			if (c.getV2() == 5) {
				this.numero5 = numero5 + 1;
			}
			if (c.getV3() == 5) {
				this.numero5 = numero5 + 1;
			}

		}
	}

	public String salvar() {

		Random gerar = new Random();

		lance.setV1(gerar.nextInt(5) + 1);
		lance.setV2(gerar.nextInt(5) + 1);
		lance.setV3(gerar.nextInt(5) + 1);

		try {
			LanceDAO.salvar(lance);
			lance = new Lance();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Lance Salvo com sucesso"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Erro ao salvar o lance"));
		}
		return null;

	}

	public String editar() {
		try {
			LanceDAO.editar(lance);
			lance = new Lance();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Lance Editado com sucesso"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Erro ao editar o lance"));
		}
		return null;
	}

	public String excluir() {
		try {
			LanceDAO.excluir(lance);
			lances.remove(lance);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Lance Excluido com sucesso"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Erro ao excluir o lance"));
		}
		return null;
	}

	public Lance getLance() {
		return lance;
	}

	public void setLance(Lance lance) {
		this.lance = lance;
	}

	public List<Lance> getLances() {
		if (lances == null) {
			lances = LanceDAO.listar();
		}
		return lances;
	}

	public void setLances(List<Lance> lances) {
		this.lances = lances;
	}

	public Integer getNumero1() {
		return numero1;
	}

	public void setNumero1(Integer numero1) {
		this.numero1 = numero1;
	}

	public Integer getNumero2() {
		return numero2;
	}

	public void setNumero2(Integer numero2) {
		this.numero2 = numero2;
	}

	public Integer getNumero3() {
		return numero3;
	}

	public void setNumero3(Integer numero3) {
		this.numero3 = numero3;
	}

	public Integer getNumero4() {
		return numero4;
	}

	public void setNumero4(Integer numero4) {
		this.numero4 = numero4;
	}

	public Integer getNumero5() {
		return numero5;
	}

	public void setNumero5(Integer numero5) {
		this.numero5 = numero5;
	}

}