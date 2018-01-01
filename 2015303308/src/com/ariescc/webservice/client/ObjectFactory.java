
package com.ariescc.webservice.server;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.ariescc.webservice.server package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RegisterResponse_QNAME = new QName("http://server.webservice.ariescc.com/", "registerResponse");
    private final static QName _JudgeUserNameAvailable_QNAME = new QName("http://server.webservice.ariescc.com/", "JudgeUserNameAvailable");
    private final static QName _QueryItemResponse_QNAME = new QName("http://server.webservice.ariescc.com/", "QueryItemResponse");
    private final static QName _Register_QNAME = new QName("http://server.webservice.ariescc.com/", "register");
    private final static QName _DeleteItemResponse_QNAME = new QName("http://server.webservice.ariescc.com/", "DeleteItemResponse");
    private final static QName _DeleteItem_QNAME = new QName("http://server.webservice.ariescc.com/", "DeleteItem");
    private final static QName _JudgeUserNameAvailableResponse_QNAME = new QName("http://server.webservice.ariescc.com/", "JudgeUserNameAvailableResponse");
    private final static QName _QueryItem_QNAME = new QName("http://server.webservice.ariescc.com/", "QueryItem");
    private final static QName _LoginResponse_QNAME = new QName("http://server.webservice.ariescc.com/", "loginResponse");
    private final static QName _SayHiResponse_QNAME = new QName("http://server.webservice.ariescc.com/", "sayHiResponse");
    private final static QName _ClearItem_QNAME = new QName("http://server.webservice.ariescc.com/", "ClearItem");
    private final static QName _Login_QNAME = new QName("http://server.webservice.ariescc.com/", "login");
    private final static QName _SayHi_QNAME = new QName("http://server.webservice.ariescc.com/", "sayHi");
    private final static QName _AddItem_QNAME = new QName("http://server.webservice.ariescc.com/", "AddItem");
    private final static QName _ClearItemResponse_QNAME = new QName("http://server.webservice.ariescc.com/", "ClearItemResponse");
    private final static QName _AddItemResponse_QNAME = new QName("http://server.webservice.ariescc.com/", "AddItemResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.ariescc.webservice.server
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link QueryItem }
     * 
     */
    public QueryItem createQueryItem() {
        return new QueryItem();
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link SayHiResponse }
     * 
     */
    public SayHiResponse createSayHiResponse() {
        return new SayHiResponse();
    }

    /**
     * Create an instance of {@link DeleteItem }
     * 
     */
    public DeleteItem createDeleteItem() {
        return new DeleteItem();
    }

    /**
     * Create an instance of {@link JudgeUserNameAvailableResponse }
     * 
     */
    public JudgeUserNameAvailableResponse createJudgeUserNameAvailableResponse() {
        return new JudgeUserNameAvailableResponse();
    }

    /**
     * Create an instance of {@link ClearItemResponse }
     * 
     */
    public ClearItemResponse createClearItemResponse() {
        return new ClearItemResponse();
    }

    /**
     * Create an instance of {@link AddItem }
     * 
     */
    public AddItem createAddItem() {
        return new AddItem();
    }

    /**
     * Create an instance of {@link AddItemResponse }
     * 
     */
    public AddItemResponse createAddItemResponse() {
        return new AddItemResponse();
    }

    /**
     * Create an instance of {@link ClearItem }
     * 
     */
    public ClearItem createClearItem() {
        return new ClearItem();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link SayHi }
     * 
     */
    public SayHi createSayHi() {
        return new SayHi();
    }

    /**
     * Create an instance of {@link JudgeUserNameAvailable }
     * 
     */
    public JudgeUserNameAvailable createJudgeUserNameAvailable() {
        return new JudgeUserNameAvailable();
    }

    /**
     * Create an instance of {@link RegisterResponse }
     * 
     */
    public RegisterResponse createRegisterResponse() {
        return new RegisterResponse();
    }

    /**
     * Create an instance of {@link DeleteItemResponse }
     * 
     */
    public DeleteItemResponse createDeleteItemResponse() {
        return new DeleteItemResponse();
    }

    /**
     * Create an instance of {@link QueryItemResponse }
     * 
     */
    public QueryItemResponse createQueryItemResponse() {
        return new QueryItemResponse();
    }

    /**
     * Create an instance of {@link Register }
     * 
     */
    public Register createRegister() {
        return new Register();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.ariescc.com/", name = "registerResponse")
    public JAXBElement<RegisterResponse> createRegisterResponse(RegisterResponse value) {
        return new JAXBElement<RegisterResponse>(_RegisterResponse_QNAME, RegisterResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JudgeUserNameAvailable }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.ariescc.com/", name = "JudgeUserNameAvailable")
    public JAXBElement<JudgeUserNameAvailable> createJudgeUserNameAvailable(JudgeUserNameAvailable value) {
        return new JAXBElement<JudgeUserNameAvailable>(_JudgeUserNameAvailable_QNAME, JudgeUserNameAvailable.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryItemResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.ariescc.com/", name = "QueryItemResponse")
    public JAXBElement<QueryItemResponse> createQueryItemResponse(QueryItemResponse value) {
        return new JAXBElement<QueryItemResponse>(_QueryItemResponse_QNAME, QueryItemResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Register }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.ariescc.com/", name = "register")
    public JAXBElement<Register> createRegister(Register value) {
        return new JAXBElement<Register>(_Register_QNAME, Register.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteItemResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.ariescc.com/", name = "DeleteItemResponse")
    public JAXBElement<DeleteItemResponse> createDeleteItemResponse(DeleteItemResponse value) {
        return new JAXBElement<DeleteItemResponse>(_DeleteItemResponse_QNAME, DeleteItemResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteItem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.ariescc.com/", name = "DeleteItem")
    public JAXBElement<DeleteItem> createDeleteItem(DeleteItem value) {
        return new JAXBElement<DeleteItem>(_DeleteItem_QNAME, DeleteItem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JudgeUserNameAvailableResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.ariescc.com/", name = "JudgeUserNameAvailableResponse")
    public JAXBElement<JudgeUserNameAvailableResponse> createJudgeUserNameAvailableResponse(JudgeUserNameAvailableResponse value) {
        return new JAXBElement<JudgeUserNameAvailableResponse>(_JudgeUserNameAvailableResponse_QNAME, JudgeUserNameAvailableResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryItem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.ariescc.com/", name = "QueryItem")
    public JAXBElement<QueryItem> createQueryItem(QueryItem value) {
        return new JAXBElement<QueryItem>(_QueryItem_QNAME, QueryItem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.ariescc.com/", name = "loginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHiResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.ariescc.com/", name = "sayHiResponse")
    public JAXBElement<SayHiResponse> createSayHiResponse(SayHiResponse value) {
        return new JAXBElement<SayHiResponse>(_SayHiResponse_QNAME, SayHiResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClearItem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.ariescc.com/", name = "ClearItem")
    public JAXBElement<ClearItem> createClearItem(ClearItem value) {
        return new JAXBElement<ClearItem>(_ClearItem_QNAME, ClearItem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.ariescc.com/", name = "login")
    public JAXBElement<Login> createLogin(Login value) {
        return new JAXBElement<Login>(_Login_QNAME, Login.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHi }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.ariescc.com/", name = "sayHi")
    public JAXBElement<SayHi> createSayHi(SayHi value) {
        return new JAXBElement<SayHi>(_SayHi_QNAME, SayHi.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddItem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.ariescc.com/", name = "AddItem")
    public JAXBElement<AddItem> createAddItem(AddItem value) {
        return new JAXBElement<AddItem>(_AddItem_QNAME, AddItem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClearItemResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.ariescc.com/", name = "ClearItemResponse")
    public JAXBElement<ClearItemResponse> createClearItemResponse(ClearItemResponse value) {
        return new JAXBElement<ClearItemResponse>(_ClearItemResponse_QNAME, ClearItemResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddItemResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.ariescc.com/", name = "AddItemResponse")
    public JAXBElement<AddItemResponse> createAddItemResponse(AddItemResponse value) {
        return new JAXBElement<AddItemResponse>(_AddItemResponse_QNAME, AddItemResponse.class, null, value);
    }

}
