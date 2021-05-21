
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package courseallocationsystem.analizadores;

import courseallocationsystem.edd.list.CircularList;
import courseallocationsystem.edd.list.List;
import courseallocationsystem.edd.table.HashTable;
import courseallocationsystem.edd.tree.ArbolAVL;
import courseallocationsystem.edd.tree.BTree;
import courseallocationsystem.model.Asignacion;
import courseallocationsystem.model.Catedratico;
import courseallocationsystem.model.Curso;
import courseallocationsystem.model.Edificio;
import courseallocationsystem.model.Estudiante;
import courseallocationsystem.model.Horario;
import courseallocationsystem.model.Salon;
import courseallocationsystem.model.Usuario;
import courseallocationsystem.validator.AsignacionValidator;
import courseallocationsystem.validator.CatedraticoValidator;
import courseallocationsystem.validator.CursoValidator;
import courseallocationsystem.validator.EdificioValidator;
import courseallocationsystem.validator.EstudianteValidator;
import courseallocationsystem.validator.HorarioValidator;
import courseallocationsystem.validator.SalonValidator;
import courseallocationsystem.validator.UserValidator;
import java.util.ArrayList;
import java_cup.runtime.Symbol;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class Parser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return Sym.class;
}

  /** Default constructor. */
  @Deprecated
  public Parser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public Parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public Parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\026\000\002\002\004\000\002\002\004\000\002\002" +
    "\003\000\002\003\005\000\002\004\005\000\002\004\005" +
    "\000\002\004\005\000\002\004\005\000\002\004\005\000" +
    "\002\004\005\000\002\004\005\000\002\004\005\000\002" +
    "\005\015\000\002\015\003\000\002\015\003\000\002\006" +
    "\013\000\002\007\005\000\002\010\011\000\002\011\013" +
    "\000\002\012\013\000\002\013\023\000\002\014\011" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\152\000\022\004\006\005\013\006\012\007\010\010" +
    "\014\011\011\012\004\013\015\001\002\000\004\016\132" +
    "\001\002\000\004\017\130\001\002\000\004\016\111\001" +
    "\002\000\024\002\107\004\006\005\013\006\012\007\010" +
    "\010\014\011\011\012\004\013\015\001\002\000\004\016" +
    "\076\001\002\000\004\016\063\001\002\000\004\016\056" +
    "\001\002\000\004\016\043\001\002\000\004\016\030\001" +
    "\002\000\004\016\017\001\002\000\024\002\uffff\004\uffff" +
    "\005\uffff\006\uffff\007\uffff\010\uffff\011\uffff\012\uffff\013" +
    "\uffff\001\002\000\004\024\021\001\002\000\004\017\ufff6" +
    "\001\002\000\004\020\022\001\002\000\004\024\023\001" +
    "\002\000\004\020\024\001\002\000\004\024\025\001\002" +
    "\000\004\020\026\001\002\000\004\024\027\001\002\000" +
    "\004\017\uffec\001\002\000\004\024\032\001\002\000\004" +
    "\017\ufff9\001\002\000\004\020\033\001\002\000\004\022" +
    "\034\001\002\000\004\023\035\001\002\000\004\022\036" +
    "\001\002\000\004\020\037\001\002\000\004\022\040\001" +
    "\002\000\004\023\041\001\002\000\004\022\042\001\002" +
    "\000\004\017\uffef\001\002\000\004\024\045\001\002\000" +
    "\004\017\ufffc\001\002\000\004\020\046\001\002\000\004" +
    "\022\047\001\002\000\004\023\050\001\002\000\004\022" +
    "\051\001\002\000\004\020\052\001\002\000\004\022\053" +
    "\001\002\000\004\023\054\001\002\000\004\022\055\001" +
    "\002\000\004\017\ufff2\001\002\000\004\022\060\001\002" +
    "\000\004\017\ufffb\001\002\000\004\023\061\001\002\000" +
    "\004\022\062\001\002\000\004\017\ufff1\001\002\000\004" +
    "\024\065\001\002\000\004\017\ufff8\001\002\000\004\020" +
    "\066\001\002\000\004\022\067\001\002\000\004\023\070" +
    "\001\002\000\004\022\071\001\002\000\004\020\072\001" +
    "\002\000\004\024\073\001\002\000\004\020\074\001\002" +
    "\000\004\024\075\001\002\000\004\017\uffee\001\002\000" +
    "\004\022\100\001\002\000\004\017\ufffa\001\002\000\004" +
    "\023\101\001\002\000\004\022\102\001\002\000\004\020" +
    "\103\001\002\000\004\024\104\001\002\000\004\020\105" +
    "\001\002\000\004\024\106\001\002\000\004\017\ufff0\001" +
    "\002\000\004\002\000\001\002\000\024\002\001\004\001" +
    "\005\001\006\001\007\001\010\001\011\001\012\001\013" +
    "\001\001\002\000\004\024\113\001\002\000\004\017\ufffd" +
    "\001\002\000\004\020\114\001\002\000\004\022\115\001" +
    "\002\000\004\023\116\001\002\000\004\022\117\001\002" +
    "\000\004\020\120\001\002\000\004\022\121\001\002\000" +
    "\004\023\122\001\002\000\004\022\123\001\002\000\004" +
    "\020\124\001\002\000\006\014\127\015\125\001\002\000" +
    "\004\017\ufff3\001\002\000\004\017\ufff5\001\002\000\004" +
    "\017\ufff4\001\002\000\004\021\131\001\002\000\024\002" +
    "\ufffe\004\ufffe\005\ufffe\006\ufffe\007\ufffe\010\ufffe\011\ufffe" +
    "\012\ufffe\013\ufffe\001\002\000\004\024\134\001\002\000" +
    "\004\017\ufff7\001\002\000\004\020\135\001\002\000\004" +
    "\022\136\001\002\000\004\023\137\001\002\000\004\022" +
    "\140\001\002\000\004\020\141\001\002\000\004\022\142" +
    "\001\002\000\004\023\143\001\002\000\004\022\144\001" +
    "\002\000\004\020\145\001\002\000\004\024\146\001\002" +
    "\000\004\020\147\001\002\000\004\024\150\001\002\000" +
    "\004\020\151\001\002\000\004\025\152\001\002\000\004" +
    "\020\153\001\002\000\004\024\154\001\002\000\004\017" +
    "\uffed\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\152\000\010\002\006\003\015\004\004\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\006" +
    "\003\107\004\004\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\004\014\017\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\004\011\030\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\004\006\043\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\004\007\056\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\004\012\063\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\004" +
    "\010\076\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\004\005\111\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\004\015\125\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\004\013\132\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$Parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$Parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$Parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}




    private ArrayList<String> errores = new ArrayList();

    private CircularList<Usuario, Integer> usuarios = new CircularList();
    private CircularList<Edificio, String> edificios = new CircularList();
    private CircularList<Curso, Integer> cursos = new CircularList();
    private HashTable<Estudiante, Integer> estudiantes = new HashTable(37, 0.55f);
    private ArbolAVL<Catedratico, Integer> catedraticos = new ArbolAVL();
    private BTree<Horario, Integer> horarios = new BTree();

    public ArrayList<String> getErrores(){
        return this.errores;
    }

    public CircularList<Usuario, Integer> getUsuarios() {
        return this.usuarios;
    }

    public CircularList<Edificio, String> getEdificios() {
        return this.edificios;
    }

    public CircularList<Curso, Integer> getCursos() {
        return this.cursos;
    }

    public HashTable<Estudiante, Integer> getEstudiantes() {
        return this.estudiantes;
    }

    public ArbolAVL<Catedratico, Integer> getCatedraticos() {
        return this.catedraticos;
    }

    public BTree<Horario, Integer> getHorarios() {
        return this.horarios;
    }

    public void syntax_error(Symbol s) {
        String ss =  (String) s.value;
        StringBuilder descripcion = new StringBuilder("Se esperaba: ");
        expected_token_ids().forEach(x -> descripcion.append(symbl_name_from_id(x)).append(", "));
        errores.add("Error en :" + ss + ", " + descripcion);
    }

    public void unrecovered_syntax_error(Symbol cur_token){
        String t = (String) cur_token.value;
        System.out.println("Error irrecuperable " + t);
    }



/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$Parser$actions {
  private final Parser parser;

  /** Constructor */
  CUP$Parser$actions(Parser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$Parser$do_action_part00000000(
    int                        CUP$Parser$act_num,
    java_cup.runtime.lr_parser CUP$Parser$parser,
    java.util.Stack            CUP$Parser$stack,
    int                        CUP$Parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$Parser$result;

      /* select the action based on the action number */
      switch (CUP$Parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // inicio ::= inicio entidad 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("inicio",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= inicio EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		RESULT = start_val;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$Parser$parser.done_parsing();
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // inicio ::= entidad 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("inicio",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // entidad ::= startEntidad CLOSE_ROUND_BRACKET SEMI 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("entidad",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // startEntidad ::= USUARIO OPEN_ROUND_BRACKET paramsUser 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("startEntidad",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // startEntidad ::= ESTUDIANTE OPEN_ROUND_BRACKET paramsEstudiante 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("startEntidad",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // startEntidad ::= EDIFICIO OPEN_ROUND_BRACKET paramsEdificio 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("startEntidad",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // startEntidad ::= SALON OPEN_ROUND_BRACKET paramsSalon 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("startEntidad",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // startEntidad ::= CATEDRATICO OPEN_ROUND_BRACKET paramsCatedratico 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("startEntidad",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // startEntidad ::= CURSO OPEN_ROUND_BRACKET paramsCurso 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("startEntidad",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // startEntidad ::= HORARIO OPEN_ROUND_BRACKET paramsHorario 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("startEntidad",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // startEntidad ::= ASIGNAR OPEN_ROUND_BRACKET paramsAsignar 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("startEntidad",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // paramsUser ::= ENTERO COMMA QUOTE_MARK LITERAL QUOTE_MARK COMMA QUOTE_MARK LITERAL QUOTE_MARK COMMA typeUser 
            {
              Object RESULT =null;
		int ileft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-10)).left;
		int iright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-10)).right;
		String i = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-10)).value;
		int nameleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-7)).left;
		int nameright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-7)).right;
		String name = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-7)).value;
		int passleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).left;
		int passright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).right;
		String pass = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-3)).value;
		int tleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int tright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String t = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		
            Integer id = Integer.parseInt(i);
            String error = UserValidator.validateUser(usuarios, estudiantes, id, t);
            if (error.isEmpty()) {
                usuarios.add(new Usuario(name, pass, t, id));
            } else {
                errores.add(error);
            }
        
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("paramsUser",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-10)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // typeUser ::= USR_COLABORADOR 
            {
              String RESULT =null;
		int tleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int tright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String t = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		RESULT = t;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("typeUser",11, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // typeUser ::= USR_ESTUDIANTE 
            {
              String RESULT =null;
		int tleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int tright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String t = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		RESULT = t;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("typeUser",11, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // paramsEstudiante ::= ENTERO COMMA QUOTE_MARK LITERAL QUOTE_MARK COMMA QUOTE_MARK LITERAL QUOTE_MARK 
            {
              Object RESULT =null;
		int ileft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-8)).left;
		int iright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-8)).right;
		String i = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-8)).value;
		int nameleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-5)).left;
		int nameright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-5)).right;
		String name = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-5)).value;
		int dirleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int dirright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		String dir = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		
            Integer id = Integer.parseInt(i);
            String error = EstudianteValidator.validateEstudiante(estudiantes, id);
            if (error.isEmpty()) {
                estudiantes.add(new Estudiante(name, dir, id));
            } else {
                errores.add(error);
            }
        
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("paramsEstudiante",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-8)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // paramsEdificio ::= QUOTE_MARK LITERAL QUOTE_MARK 
            {
              Object RESULT =null;
		int nameleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int nameright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		String name = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		
            String error = EdificioValidator.validateEdificio(edificios, name);
            if (error.isEmpty()) {
                edificios.add(new Edificio(name));
            } else {
                errores.add(error);
            }
        
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("paramsEdificio",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // paramsSalon ::= QUOTE_MARK LITERAL QUOTE_MARK COMMA ENTERO COMMA ENTERO 
            {
              Object RESULT =null;
		int sleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-5)).left;
		int sright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-5)).right;
		String s = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-5)).value;
		int ileft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int iright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		String i = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int cleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int cright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String c = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		
            Integer id = Integer.parseInt(i);
            String error = SalonValidator.validateSalon(edificios, s, id);
            if (error.isEmpty()) {
                edificios.get(s).getSalones().add(new Salon(Integer.parseInt(c), s, id));
            }
        
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("paramsSalon",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-6)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // paramsCatedratico ::= ENTERO COMMA QUOTE_MARK LITERAL QUOTE_MARK COMMA QUOTE_MARK LITERAL QUOTE_MARK 
            {
              Object RESULT =null;
		int ileft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-8)).left;
		int iright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-8)).right;
		String i = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-8)).value;
		int nameleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-5)).left;
		int nameright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-5)).right;
		String name = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-5)).value;
		int dirleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int dirright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		String dir = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		
            Integer id = Integer.parseInt(i);
            String error = CatedraticoValidator.validateCatedratico(catedraticos, id);

            if (error.isEmpty()) {
                catedraticos.add(new Catedratico(name, dir, id));
            } else {
                errores.add(error);
            }
        
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("paramsCatedratico",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-8)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // paramsCurso ::= ENTERO COMMA QUOTE_MARK LITERAL QUOTE_MARK COMMA ENTERO COMMA ENTERO 
            {
              Object RESULT =null;
		int ileft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-8)).left;
		int iright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-8)).right;
		String i = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-8)).value;
		int nameleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-5)).left;
		int nameright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-5)).right;
		String name = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-5)).value;
		int sleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int sright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		String s = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int nleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int nright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String n = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		
            Integer id = Integer.parseInt(i);
            String error = CursoValidator.validateCurso(cursos, id);
            if (error.isEmpty()) {
                cursos.add(new Curso(name, Integer.parseInt(s), Integer.parseInt(n), id));
            } else {
                errores.add(error);
            }
        
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("paramsCurso",8, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-8)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // paramsHorario ::= ENTERO COMMA QUOTE_MARK LITERAL QUOTE_MARK COMMA QUOTE_MARK LITERAL QUOTE_MARK COMMA ENTERO COMMA ENTERO COMMA NAME_ED COMMA ENTERO 
            {
              Object RESULT =null;
		int ileft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-16)).left;
		int iright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-16)).right;
		String i = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-16)).value;
		int pleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-13)).left;
		int pright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-13)).right;
		String p = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-13)).value;
		int dleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-9)).left;
		int dright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-9)).right;
		String d = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-9)).value;
		int iCurleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-6)).left;
		int iCurright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-6)).right;
		String iCur = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-6)).value;
		int idSleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)).left;
		int idSright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)).right;
		String idS = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-4)).value;
		int iEdleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int iEdright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		String iEd = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int iCatedleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int iCatedright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String iCated = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		
            Integer id = Integer.parseInt(i);
            Integer idCurso = Integer.parseInt(iCur);
            Integer idCatedra = Integer.parseInt(iCated);
            Integer idSalon = Integer.parseInt(idS);
            String error = HorarioValidator.validateHorario(horarios, cursos, edificios, catedraticos, id, idCurso, idCatedra, idSalon, iEd);
            if (error.isEmpty()) {
                horarios.add(new Horario(p, d, idCurso, idSalon, iEd, idCatedra, id));
            } else {
                errores.add(error);
            }
        
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("paramsHorario",9, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-16)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // paramsAsignar ::= ENTERO COMMA ENTERO COMMA ENTERO COMMA ENTERO 
            {
              Object RESULT =null;
		int iEstleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-6)).left;
		int iEstright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-6)).right;
		String iEst = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-6)).value;
		int iHoleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)).left;
		int iHoright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)).right;
		String iHo = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-4)).value;
		int zleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int zright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		String z = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int fleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int fright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String f = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		
            Integer idEstudiante = Integer.parseInt(iEst);
            Integer idHorario = Integer.parseInt(iHo);
            String error = AsignacionValidator.validateAsignacion(horarios, idEstudiante, idHorario);
            if (error.isEmpty()) {
                horarios.get(idHorario).getAsignaciones().add(new Asignacion(idEstudiante, idHorario, Integer.parseInt(z), Integer.parseInt(f)));
            } else {
                errores.add(error);
            }
        
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("paramsAsignar",10, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-6)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$Parser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$Parser$do_action(
    int                        CUP$Parser$act_num,
    java_cup.runtime.lr_parser CUP$Parser$parser,
    java.util.Stack            CUP$Parser$stack,
    int                        CUP$Parser$top)
    throws java.lang.Exception
    {
              return CUP$Parser$do_action_part00000000(
                               CUP$Parser$act_num,
                               CUP$Parser$parser,
                               CUP$Parser$stack,
                               CUP$Parser$top);
    }
}

}
