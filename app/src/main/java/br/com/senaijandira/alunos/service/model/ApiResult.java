package br.com.senaijandira.alunos.service.model;

public class ApiResult {

    private boolean sucesso;
    private String msg;

    public boolean getSucesso() {
        return sucesso;
    }

    public void setSucesso(boolean sucesso) {
        this.sucesso = sucesso;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
