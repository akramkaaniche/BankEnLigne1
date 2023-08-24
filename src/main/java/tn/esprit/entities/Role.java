package tn.esprit.entities;
import org.springframework.security.core.GrantedAuthority;


public enum Role implements GrantedAuthority {
	Client, PartenaireAssurance, GestionnaireClient, RH, ConseillerClient;
	@Override
	public String getAuthority() {

		return "ROLE_" + name();

		}
}
