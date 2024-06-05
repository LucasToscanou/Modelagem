// File: Foto.java
package outras;

public class Foto {
    private String url;
    private String descricao;

    public Foto(String url, String descricao) {
        this.url = url;
        this.descricao = descricao;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Foto{" +
                "url='" + url + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
