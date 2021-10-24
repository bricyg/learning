package site.bitinit.salary.domain.gateway;

import site.bitinit.salary.domain.affiliation.Affiliation;

/**
 * @author john
 * @date 2021/10/24
 */
public interface AffiliationGateway {

    void save(Affiliation affiliation);
}
