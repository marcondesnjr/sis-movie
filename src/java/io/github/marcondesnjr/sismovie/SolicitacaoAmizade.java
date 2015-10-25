package io.github.marcondesnjr.sismovie;


public class SolicitacaoAmizade {

    private Usuario remetente;
    private Usuario destinatario;
    private EstadoAmizade estado;

    public SolicitacaoAmizade(Usuario remetente, Usuario destinatario) {
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.estado = EstadoAmizade.PEDENTE;
    }   
    
    public Usuario getRemetente() {
        return remetente;
    }

    public void setRemetente(Usuario remetente) {
        this.remetente = remetente;
    }

    public Usuario getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Usuario destinatario) {
        this.destinatario = destinatario;
    }

    public EstadoAmizade getEstado() {
        return estado;
    }

    public void setEstado(EstadoAmizade estado) {
        this.estado = estado;
    }
    

}
