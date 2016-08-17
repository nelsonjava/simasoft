package co.simasoft.beans;

import co.simasoft.models.*;

import java.util.*;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class FindBean {

    @PersistenceContext(unitName = "networkingPU-JTA")
    private EntityManager em;

//      ---------------------- Hosts ------------------------

    public List<Hosts> AllHosts() {
        List<Hosts> results = em.createQuery("SELECT o FROM Hosts o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Hosts>();
        }
        return results;
    }

    public Hosts idHosts(Long id) {

        Hosts hosts = new Hosts();
        List<Hosts> results = em.createQuery("SELECT o FROM Hosts o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           hosts = results.get(0);
        }
        return hosts;
    }

//      ---------------------- Address ------------------------

    public List<Address> AllAddress() {
        List<Address> results = em.createQuery("SELECT o FROM Address o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Address>();
        }
        return results;
    }

    public Address idAddress(Long id) {

        Address address = new Address();
        List<Address> results = em.createQuery("SELECT o FROM Address o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           address = results.get(0);
        }
        return address;
    }

//      ---------------------- Companies ------------------------

    public List<Companies> AllCompanies() {
        List<Companies> results = em.createQuery("SELECT o FROM Companies o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Companies>();
        }
        return results;
    }

    public Companies idCompanies(Long id) {

        Companies companies = new Companies();
        List<Companies> results = em.createQuery("SELECT o FROM Companies o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           companies = results.get(0);
        }
        return companies;
    }

//      ---------------------- PatchPanelsPorts ------------------------

    public List<PatchPanelsPorts> AllPatchPanelsPorts() {
        List<PatchPanelsPorts> results = em.createQuery("SELECT o FROM PatchPanelsPorts o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<PatchPanelsPorts>();
        }
        return results;
    }

    public PatchPanelsPorts idPatchPanelsPorts(Long id) {

        PatchPanelsPorts patchPanelsPorts = new PatchPanelsPorts();
        List<PatchPanelsPorts> results = em.createQuery("SELECT o FROM PatchPanelsPorts o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           patchPanelsPorts = results.get(0);
        }
        return patchPanelsPorts;
    }

//      ---------------------- Employees ------------------------

    public List<Employees> AllEmployees() {
        List<Employees> results = em.createQuery("SELECT o FROM Employees o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Employees>();
        }
        return results;
    }

    public Employees idEmployees(Long id) {

        Employees employees = new Employees();
        List<Employees> results = em.createQuery("SELECT o FROM Employees o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           employees = results.get(0);
        }
        return employees;
    }

//      ---------------------- ItemsNames ------------------------

    public List<ItemsNames> AllItemsNames() {
        List<ItemsNames> results = em.createQuery("SELECT o FROM ItemsNames o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<ItemsNames>();
        }
        return results;
    }

    public ItemsNames idItemsNames(Long id) {

        ItemsNames itemsNames = new ItemsNames();
        List<ItemsNames> results = em.createQuery("SELECT o FROM ItemsNames o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           itemsNames = results.get(0);
        }
        return itemsNames;
    }

//      ---------------------- Persons ------------------------

    public List<Persons> AllPersons() {
        List<Persons> results = em.createQuery("SELECT o FROM Persons o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Persons>();
        }
        return results;
    }

    public Persons idPersons(Long id) {

        Persons persons = new Persons();
        List<Persons> results = em.createQuery("SELECT o FROM Persons o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           persons = results.get(0);
        }
        return persons;
    }

//      ---------------------- Ids ------------------------

    public List<Ids> AllIds() {
        List<Ids> results = em.createQuery("SELECT o FROM Ids o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Ids>();
        }
        return results;
    }

    public Ids idIds(Long id) {

        Ids ids = new Ids();
        List<Ids> results = em.createQuery("SELECT o FROM Ids o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           ids = results.get(0);
        }
        return ids;
    }

//      ---------------------- Items ------------------------

    public List<Items> AllItems() {
        List<Items> results = em.createQuery("SELECT o FROM Items o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Items>();
        }
        return results;
    }

    public Items idItems(Long id) {

        Items items = new Items();
        List<Items> results = em.createQuery("SELECT o FROM Items o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           items = results.get(0);
        }
        return items;
    }

//      ---------------------- Emails ------------------------

    public List<Emails> AllEmails() {
        List<Emails> results = em.createQuery("SELECT o FROM Emails o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Emails>();
        }
        return results;
    }

    public Emails idEmails(Long id) {

        Emails emails = new Emails();
        List<Emails> results = em.createQuery("SELECT o FROM Emails o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           emails = results.get(0);
        }
        return emails;
    }

//      ---------------------- ItemsTypes ------------------------

    public List<ItemsTypes> AllItemsTypes() {
        List<ItemsTypes> results = em.createQuery("SELECT o FROM ItemsTypes o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<ItemsTypes>();
        }
        return results;
    }

    public ItemsTypes idItemsTypes(Long id) {

        ItemsTypes itemsTypes = new ItemsTypes();
        List<ItemsTypes> results = em.createQuery("SELECT o FROM ItemsTypes o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           itemsTypes = results.get(0);
        }
        return itemsTypes;
    }

//      ---------------------- EmployeesTypes ------------------------

    public List<EmployeesTypes> AllEmployeesTypes() {
        List<EmployeesTypes> results = em.createQuery("SELECT o FROM EmployeesTypes o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<EmployeesTypes>();
        }
        return results;
    }

    public EmployeesTypes idEmployeesTypes(Long id) {

        EmployeesTypes employeesTypes = new EmployeesTypes();
        List<EmployeesTypes> results = em.createQuery("SELECT o FROM EmployeesTypes o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           employeesTypes = results.get(0);
        }
        return employeesTypes;
    }

//      ---------------------- PhysicalAreas ------------------------

    public List<PhysicalAreas> AllPhysicalAreas() {
        List<PhysicalAreas> results = em.createQuery("SELECT o FROM PhysicalAreas o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<PhysicalAreas>();
        }
        return results;
    }

    public PhysicalAreas idPhysicalAreas(Long id) {

        PhysicalAreas physicalAreas = new PhysicalAreas();
        List<PhysicalAreas> results = em.createQuery("SELECT o FROM PhysicalAreas o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           physicalAreas = results.get(0);
        }
        return physicalAreas;
    }

//      ---------------------- NetworkPorts ------------------------

    public List<NetworkPorts> AllNetworkPorts() {
        List<NetworkPorts> results = em.createQuery("SELECT o FROM NetworkPorts o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<NetworkPorts>();
        }
        return results;
    }

    public NetworkPorts idNetworkPorts(Long id) {

        NetworkPorts networkPorts = new NetworkPorts();
        List<NetworkPorts> results = em.createQuery("SELECT o FROM NetworkPorts o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           networkPorts = results.get(0);
        }
        return networkPorts;
    }

//      ---------------------- HostsTypes ------------------------

    public List<HostsTypes> AllHostsTypes() {
        List<HostsTypes> results = em.createQuery("SELECT o FROM HostsTypes o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<HostsTypes>();
        }
        return results;
    }

    public HostsTypes idHostsTypes(Long id) {

        HostsTypes hostsTypes = new HostsTypes();
        List<HostsTypes> results = em.createQuery("SELECT o FROM HostsTypes o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           hostsTypes = results.get(0);
        }
        return hostsTypes;
    }

//      ---------------------- Sites ------------------------

    public List<Sites> AllSites() {
        List<Sites> results = em.createQuery("SELECT o FROM Sites o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Sites>();
        }
        return results;
    }

    public Sites idSites(Long id) {

        Sites sites = new Sites();
        List<Sites> results = em.createQuery("SELECT o FROM Sites o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           sites = results.get(0);
        }
        return sites;
    }

//      ---------------------- SwitchesPorts ------------------------

    public List<SwitchesPorts> AllSwitchesPorts() {
        List<SwitchesPorts> results = em.createQuery("SELECT o FROM SwitchesPorts o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<SwitchesPorts>();
        }
        return results;
    }

    public SwitchesPorts idSwitchesPorts(Long id) {

        SwitchesPorts switchesPorts = new SwitchesPorts();
        List<SwitchesPorts> results = em.createQuery("SELECT o FROM SwitchesPorts o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           switchesPorts = results.get(0);
        }
        return switchesPorts;
    }

//      ---------------------- TelephonesTypes ------------------------

    public List<TelephonesTypes> AllTelephonesTypes() {
        List<TelephonesTypes> results = em.createQuery("SELECT o FROM TelephonesTypes o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<TelephonesTypes>();
        }
        return results;
    }

    public TelephonesTypes idTelephonesTypes(Long id) {

        TelephonesTypes telephonesTypes = new TelephonesTypes();
        List<TelephonesTypes> results = em.createQuery("SELECT o FROM TelephonesTypes o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           telephonesTypes = results.get(0);
        }
        return telephonesTypes;
    }

//      ---------------------- Telephones ------------------------

    public List<Telephones> AllTelephones() {
        List<Telephones> results = em.createQuery("SELECT o FROM Telephones o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Telephones>();
        }
        return results;
    }

    public Telephones idTelephones(Long id) {

        Telephones telephones = new Telephones();
        List<Telephones> results = em.createQuery("SELECT o FROM Telephones o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           telephones = results.get(0);
        }
        return telephones;
    }

//      ---------------------- Brands ------------------------

    public List<Brands> AllBrands() {
        List<Brands> results = em.createQuery("SELECT o FROM Brands o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Brands>();
        }
        return results;
    }

    public Brands idBrands(Long id) {

        Brands brands = new Brands();
        List<Brands> results = em.createQuery("SELECT o FROM Brands o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           brands = results.get(0);
        }
        return brands;
    }

//      ---------------------- SitesTypes ------------------------

    public List<SitesTypes> AllSitesTypes() {
        List<SitesTypes> results = em.createQuery("SELECT o FROM SitesTypes o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<SitesTypes>();
        }
        return results;
    }

    public SitesTypes idSitesTypes(Long id) {

        SitesTypes sitesTypes = new SitesTypes();
        List<SitesTypes> results = em.createQuery("SELECT o FROM SitesTypes o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           sitesTypes = results.get(0);
        }
        return sitesTypes;
    }

//      ---------------------- PositionsCompany ------------------------

    public List<PositionsCompany> AllPositionsCompany() {
        List<PositionsCompany> results = em.createQuery("SELECT o FROM PositionsCompany o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<PositionsCompany>();
        }
        return results;
    }

    public PositionsCompany idPositionsCompany(Long id) {

        PositionsCompany positionsCompany = new PositionsCompany();
        List<PositionsCompany> results = em.createQuery("SELECT o FROM PositionsCompany o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           positionsCompany = results.get(0);
        }
        return positionsCompany;
    }

//      ---------------------- IdsTypes ------------------------

    public List<IdsTypes> AllIdsTypes() {
        List<IdsTypes> results = em.createQuery("SELECT o FROM IdsTypes o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<IdsTypes>();
        }
        return results;
    }

    public IdsTypes idIdsTypes(Long id) {

        IdsTypes idsTypes = new IdsTypes();
        List<IdsTypes> results = em.createQuery("SELECT o FROM IdsTypes o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           idsTypes = results.get(0);
        }
        return idsTypes;
    }

//      ---------------------- PhysicalAreasTypes ------------------------

    public List<PhysicalAreasTypes> AllPhysicalAreasTypes() {
        List<PhysicalAreasTypes> results = em.createQuery("SELECT o FROM PhysicalAreasTypes o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<PhysicalAreasTypes>();
        }
        return results;
    }

    public PhysicalAreasTypes idPhysicalAreasTypes(Long id) {

        PhysicalAreasTypes physicalAreasTypes = new PhysicalAreasTypes();
        List<PhysicalAreasTypes> results = em.createQuery("SELECT o FROM PhysicalAreasTypes o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           physicalAreasTypes = results.get(0);
        }
        return physicalAreasTypes;
    }

//      ---------------------- Vlans ------------------------

    public List<Vlans> AllVlans() {
        List<Vlans> results = em.createQuery("SELECT o FROM Vlans o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Vlans>();
        }
        return results;
    }

    public Vlans idVlans(Long id) {

        Vlans vlans = new Vlans();
        List<Vlans> results = em.createQuery("SELECT o FROM Vlans o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           vlans = results.get(0);
        }
        return vlans;
    }

//      ---------------------- ItemsStates ------------------------

    public List<ItemsStates> AllItemsStates() {
        List<ItemsStates> results = em.createQuery("SELECT o FROM ItemsStates o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<ItemsStates>();
        }
        return results;
    }

    public ItemsStates idItemsStates(Long id) {

        ItemsStates itemsStates = new ItemsStates();
        List<ItemsStates> results = em.createQuery("SELECT o FROM ItemsStates o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           itemsStates = results.get(0);
        }
        return itemsStates;
    }

} // Fin de clase
