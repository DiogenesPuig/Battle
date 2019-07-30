package batalla;
// se arreglo la identacion

import java.util.Scanner; // se agrego Scanner

public class Batalla {

    public static void main(String[] args) {
        int ho = 1;
        int cantidadDeLados = 10;
        int escaparr = 10;
        Dado d1 = new Dado(escaparr);
        Dado d10 = new Dado(cantidadDeLados);
        Player p1 = new Player();
        Player p2 = new Player();

        String nombre = "Baby-Amaru";
        int salud = 1000;
        int ataque = 30;
        int defensa = 50;
        BabyDragon d = new BabyDragon(d10, "Baby-Amaru", 1000, 30, 50, 0);
        BabyDragon d2 = new BabyDragon(d10, "Baby-Amaru Oscuro", 1000, 30, 50, 0);

        nombre = "Rey Arturo";
        salud = 1000;
        ataque = 30;
        defensa = 50;
        Caballero c = new Caballero(d10, "Rey Arturo", 1000, 30, 50, 0);
        Caballero c2 = new Caballero(d10, "Rey  Arturo Oscuro", 1000, 30, 50, 0);

        nombre = "Gul'dan";
        salud = 1000;
        ataque = 30;
        defensa = 50;
        Orco o = new Orco(d10, nombre, 1000, 30, 50, 0);
        Orco o2 = new Orco(d10, "Gul'dan Oscuro", 1000, 30, 50, 0);
/*
        p1.setC(c);
        p2.setO(o);
        //asdasd
        p1.setMes(1);
        p2.setMes(2);
*/
        // empieza el juego
        // elejir personaje player 1
        Scanner plyn1 = new Scanner(System.in);
        System.out.println("Ingresa tu nombre :");  
        String nombre1 = plyn1.nextLine();
        
        Scanner ply1 = new Scanner(System.in);
        System.out.println("ingresa el campeon que deseas usar: ");
        System.out.println("1 = Rey Arturo(Caballero)");
        System.out.println("2 = Gul'dan(Orco)");
        System.out.println("3 = Amaru bebe(Bebe Dragon)");
        System.out.println("no elijas otro numero");
        int p1per = ply1.nextInt();
        while(p1per > 3 || p1per < 0){
            System.out.println("Un numero del 1 al 3...");
            p1per= ply1.nextInt();
        }

        
        
        switch (p1per) {
            case 1:
                p1.setC(c);
                p1.setMes(1);
                break;
            case 2:
                p1.setO(o);
                p1.setMes(2);
                break;
            case 3:
                p1.setD(d);
                p1.setMes(3);
                break;
            default:
                break;
        }

        // elejir personaje player 2
        Scanner ply2n = new Scanner(System.in); 
        System.out.println("Ingresa tu nombre :");

        Scanner ply2 = new Scanner(System.in);
        System.out.println("ingresa el campeon que deseas usar: ");
        System.out.println("1 = Rey Arturo(Caballero)");
        System.out.println("2 = Gul'dan(Orco)");
        System.out.println("3 = Amaru bebe(Bebe Dragon)");
        System.out.println("En caso de ambos ser el mismo campeon se lo reconoce al player 2 como 'Campeon' + Oscuro ");      
        int p2per = ply2.nextInt();
        while(p2per > 3 || p2per < 0){
            System.out.println("Un numero del 1 al 3...");
            p2per= ply1.nextInt();
        }
        
        if (p1per == 1 && p2per == 1) {
            p2.setC(c2);
            p2.setMes(2);
        }
        if (p1per == 2 && p2per == 2) {
            p2.setO(o2);
            p2.setMes(2);
        }
        if (p1per == 3 && p2per == 3) {
            p2.setD(d2);
            p2.setMes(3);
        } else {
            switch (p2per) {
                case 1:
                    p2.setC(c);
                    p2.setMes(1);
                    break;
                case 2:
                    p2.setO(o);
                    p2.setMes(2);
                    break;
                case 3:
                    p2.setD(d);
                    p2.setMes(3);
                    break;
                default:
                    break;
            }
        }
        int pote1 = 4;
        int pote2 = 4;

        // caba vs caba
        while (p1.getMes() == 1 && p2.getMes() == 1) {
            int tirada = d10.tirarDado();
            System.out.println("Dado = " + tirada);

            //ataca el player 1
            if (tirada > 5) {
                Scanner s1 = new Scanner(System.in);
                System.out.println(c.getNombre() + " tienes la oportunidad de atacar ! o tambien puedes hacer otras cosas....");
                System.out.println("ingresa 1 para atacar");
                System.out.println("ingresa 2 para curarte tienes " + pote1 + " posiones");
                System.out.println("ingresa 3 para escapar");
                int elejir = s1.nextInt();
                switch (elejir) {
                    case 1:
                        //atacar
                        c.atacarCaba(c2);
                        System.out.println("Salud restante de " + c2.getNombre() + " = " + c2.getSalud());
                        break;
                    case 2:
                        //curar
                        if (pote1 > 0) {
                            c.curarse();
                            pote1--;
                            System.out.println("has bebido una posion, tienes " + pote1 + " posiones mas");

                        } else {
                            System.out.println("Ya no te quedan posiones!");
                        }
                    case 3:
                        //escapar
                        int proba = d1.tirarDado();
                        if (proba == 3) {
                            System.out.println("Lo graste escapar!");
                            c.setSalud(0);
                            c2.setSalud(0);
                        } else {
                            System.out.println("No has podido escapar!");
                        }
                    default:
                }
                //c.atacarOrco(o); // atacar al player 2
                //System.out.println("Salud restante de " + o.getNombre()  +" = " + o.getSalud());
                if (c2.estaSaludable() == false) {
                    break;
                }
            } //ataca el player 2
            else {
                Scanner s2 = new Scanner(System.in);
                System.out.println(c2.getNombre() + " tienes la oportunidad de atacar ! o tambien puedes hacer otras cosas....");
                System.out.println("ingresa 1 para atacar");
                System.out.println("ingresa 2 para curarte tienes " + pote2 + " posiones");
                System.out.println("ingresa 3 para escapar");
                int elejire = s2.nextInt();
                switch (elejire) {
                    case 1:
                        //atacar
                        c2.atacarCaba(c);
                        System.out.println("Salud restante de " + c.getNombre() + " = " + c.getSalud());
                        break;
                    case 2:
                        //curar
                        if (pote2 > 0) {
                            c2.curarse();
                            pote2--;
                            System.out.println("has bebido una posion, tienes " + pote2 + " posiones mas");

                        } else {
                            System.out.println("Ya no te quedan posiones!");
                        }
                        break;
                    case 3:
                        //escapar
                        int proba = d1.tirarDado();
                        if (proba == 3) {
                            System.out.println("Lo graste escapar!");
                            c2.setSalud(0);
                            c.setSalud(0);
                        } else {
                            System.out.println("No has podido escapar!");
                        }
                        break;
                    default:
                }
                if (c.estaSaludable() == false) {
                    break;
                }

            }
        }

        // caballero vs orco
        while (p1.getMes() == 1 && p2.getMes() == 2) {
            int tirada = d10.tirarDado();
            System.out.println("Dado = " + tirada);

            //ataca el player 1
            if (tirada > 5) {
                Scanner s1 = new Scanner(System.in);
                System.out.println(c.getNombre() + " tienes la oportunidad de atacar ! o tambien puedes hacer otras cosas....");
                System.out.println("ingresa 1 para atacar");
                System.out.println("ingresa 2 para curarte tienes " + pote1 + " posiones");
                System.out.println("ingresa 3 para escapar");
                int elejir = s1.nextInt();
                switch (elejir) {
                    case 1:
                        //atacar
                        c.atacarOrco(o);
                        System.out.println("Salud restante de " + o.getNombre() + " = " + o.getSalud());
                        break;
                    case 2:
                        //curar
                        if (pote1 > 0) {
                            c.curarse();
                            pote1--;
                            System.out.println("has bebido una posion, tienes " + pote1 + " posiones mas");

                        } else {
                            System.out.println("Ya no te quedan posiones!");
                        }
                    case 3:
                        //escapar
                        int proba = d1.tirarDado();
                        if (proba == 3) {
                            System.out.println("Lo graste escapar!");
                            c.setSalud(0);
                            o.setSalud(0);
                        } else {
                            System.out.println("No has podido escapar!");
                        }
                    default:
                }
                //c.atacarOrco(o); // atacar al player 2
                //System.out.println("Salud restante de " + o.getNombre()  +" = " + o.getSalud());
                if (o.estaSaludable() == false) {
                    break;
                }
            } //ataca el player 2
            else {
                Scanner s2 = new Scanner(System.in);
                System.out.println(o.getNombre() + " tienes la oportunidad de atacar ! o tambien puedes hacer otras cosas....");
                System.out.println("ingresa 1 para atacar");
                System.out.println("ingresa 2 para curarte tienes " + pote2 + " posiones");
                System.out.println("ingresa 3 para escapar");
                int elejire = s2.nextInt();
                switch (elejire) {
                    case 1:
                        //atacar
                        o.atacarCaba(c);
                        System.out.println("Salud restante de " + c.getNombre() + " = " + c.getSalud());
                        break;
                    case 2:
                        //curar
                        if (pote2 > 0) {
                            o.curarse();
                            pote2--;
                            System.out.println("has bebido una posion, tienes " + pote2 + " posiones mas");

                        } else {
                            System.out.println("Ya no te quedan posiones!");
                        }
                        break;
                    case 3:
                        //escapar
                        int proba = d1.tirarDado();
                        if (proba == 3) {
                            System.out.println("Lo graste escapar!");
                            o.setSalud(0);
                            c.setSalud(0);
                        } else {
                            System.out.println("No has podido escapar!");
                        }
                        break;
                    default:
                }
                if (c.estaSaludable() == false) {
                    break;
                }

            }
        }
        
        // caba vs Drake
        
        while (p1.getMes() == 1 && p2.getMes() == 3) {
            int tirada = d10.tirarDado();
            System.out.println("Dado = " + tirada);

            //ataca el player 1
            if (tirada > 5) {
                Scanner s1 = new Scanner(System.in);
                System.out.println(c.getNombre() + " tienes la oportunidad de atacar ! o tambien puedes hacer otras cosas....");
                System.out.println("ingresa 1 para atacar");
                System.out.println("ingresa 2 para curarte tienes " + pote1 + " posiones");
                System.out.println("ingresa 3 para escapar");
                int elejir = s1.nextInt();
                switch (elejir) {
                    case 1:
                        //atacar
                        c.atacarDrag(d);
                        System.out.println("Salud restante de " + d.getNombre() + " = " + d.getSalud());
                        break;
                    case 2:
                        //curar
                        if (pote1 > 0) {
                            c.curarse();
                            pote1--;
                            System.out.println("has bebido una posion, tienes " + pote1 + " posiones mas");

                        } else {
                            System.out.println("Ya no te quedan posiones!");
                        }
                    case 3:
                        //escapar
                        int proba = d1.tirarDado();
                        if (proba == 3) {
                            System.out.println("Lo graste escapar!");
                            c.setSalud(0);
                            d2.setSalud(0);
                        } else {
                            System.out.println("No has podido escapar!");
                        }
                    default:
                }
                
                if (d2.estaSaludable() == false) {
                    break;
                }
            } //ataca el player 2
            else {
                Scanner s2 = new Scanner(System.in);
                System.out.println(o.getNombre() + " tienes la oportunidad de atacar ! o tambien puedes hacer otras cosas....");
                System.out.println("ingresa 1 para atacar");
                System.out.println("ingresa 2 para curarte tienes " + pote2 + " posiones");
                System.out.println("ingresa 3 para escapar");
                int elejire = s2.nextInt();
                switch (elejire) {
                    case 1:
                        //atacar
                        d.atacarCaba(c);
                        System.out.println("Salud restante de " + c.getNombre() + " = " + c.getSalud());
                        break;
                    case 2:
                        //curar
                        if (pote2 > 0) {
                            d.curarse();
                            pote2--;
                            System.out.println("has bebido una posion, tienes " + pote2 + " posiones mas");

                        } else {
                            System.out.println("Ya no te quedan posiones!");
                        }
                        break;
                    case 3:
                        //escapar
                        int proba = d1.tirarDado();
                        if (proba == 3) {
                            System.out.println("Lo graste escapar!");
                            d.setSalud(0);
                            c.setSalud(0);
                        } else {
                            System.out.println("No has podido escapar!");
                        }
                        break;
                    default:
                }
                if (c.estaSaludable() == false) {
                    break;
                }

            }
        }
        
        // orco vs caba
        
        while (p1.getMes() == 2 && p2.getMes() == 1) {
            int tirada = d10.tirarDado();
            System.out.println("Dado = " + tirada);

            //ataca el player 1
            if (tirada > 5) {
                Scanner s1 = new Scanner(System.in);
                System.out.println(o.getNombre() + " tienes la oportunidad de atacar ! o tambien puedes hacer otras cosas....");
                System.out.println("ingresa 1 para atacar");
                System.out.println("ingresa 2 para curarte tienes " + pote1 + " posiones");
                System.out.println("ingresa 3 para escapar");
                int elejir = s1.nextInt();
                switch (elejir) {
                    case 1:
                        //atacar
                        o.atacarCaba(c);
                        System.out.println("Salud restante de " + c.getNombre() + " = " + c.getSalud());
                        break;
                    case 2:
                        //curar
                        if (pote1 > 0) {
                            o.curarse();
                            pote1--;
                            System.out.println("has bebido una posion, tienes " + pote1 + " posiones mas");

                        } else {
                            System.out.println("Ya no te quedan posiones!");
                        }
                    case 3:
                        //escapar
                        int proba = d1.tirarDado();
                        if (proba == 3) {
                            System.out.println("Lo graste escapar!");
                            o.setSalud(0);
                            c.setSalud(0);
                        } else {
                            System.out.println("No has podido escapar!");
                        }
                    default:
                }
                //c.atacarOrco(o); // atacar al player 2
                //System.out.println("Salud restante de " + o.getNombre()  +" = " + o.getSalud());
                if (c.estaSaludable() == false) {
                    break;
                }
            } //ataca el player 2
            else {
                Scanner s2 = new Scanner(System.in);
                System.out.println(c.getNombre() + " tienes la oportunidad de atacar ! o tambien puedes hacer otras cosas....");
                System.out.println("ingresa 1 para atacar");
                System.out.println("ingresa 2 para curarte tienes " + pote2 + " posiones");
                System.out.println("ingresa 3 para escapar");
                int elejire = s2.nextInt();
                switch (elejire) {
                    case 1:
                        //atacar
                        c.atacarOrco(o);
                        System.out.println("Salud restante de " + o.getNombre() + " = " + o.getSalud());
                        break;
                    case 2:
                        //curar
                        if (pote2 > 0) {
                            c.curarse();
                            pote2--;
                            System.out.println("has bebido una posion, tienes " + pote2 + " posiones mas");

                        } else {
                            System.out.println("Ya no te quedan posiones!");
                        }
                        break;
                    case 3:
                        //escapar
                        int proba = d1.tirarDado();
                        if (proba == 3) {
                            System.out.println("Lo graste escapar!");
                            c.setSalud(0);
                            o.setSalud(0);
                        } else {
                            System.out.println("No has podido escapar!");
                        }
                        break;
                    default:
                }
                if (o.estaSaludable() == false) {
                    break;
                }

            }
        }
        
        // orco vs orco
        
        while (p1.getMes() == 2 && p2.getMes() == 2) {
            int tirada = d10.tirarDado();
            System.out.println("Dado = " + tirada);

            //ataca el player 1
            if (tirada > 5) {
                Scanner s1 = new Scanner(System.in);
                System.out.println(o.getNombre() + " tienes la oportunidad de atacar ! o tambien puedes hacer otras cosas....");
                System.out.println("ingresa 1 para atacar");
                System.out.println("ingresa 2 para curarte tienes " + pote1 + " posiones");
                System.out.println("ingresa 3 para escapar");
                int elejir = s1.nextInt();
                switch (elejir) {
                    case 1:
                        //atacar
                        o.atacarOrco(o2);
                        System.out.println("Salud restante de " + o2.getNombre() + " = " + o2.getSalud());
                        break;
                    case 2:
                        //curar
                        if (pote1 > 0) {
                            o.curarse();
                            pote1--;
                            System.out.println("has bebido una posion, tienes " + pote1 + " posiones mas");

                        } else {
                            System.out.println("Ya no te quedan posiones!");
                        }
                    case 3:
                        //escapar
                        int proba = d1.tirarDado();
                        if (proba == 3) {
                            System.out.println("Lo graste escapar!");
                            o.setSalud(0);
                            o2.setSalud(0);
                        } else {
                            System.out.println("No has podido escapar!");
                        }
                    default:
                }
                //c.atacarOrco(o); // atacar al player 2
                //System.out.println("Salud restante de " + o.getNombre()  +" = " + o.getSalud());
                if (o2.estaSaludable() == false) {
                    break;
                }
            } //ataca el player 2
            else {
                Scanner s2 = new Scanner(System.in);
                System.out.println(o2.getNombre() + " tienes la oportunidad de atacar ! o tambien puedes hacer otras cosas....");
                System.out.println("ingresa 1 para atacar");
                System.out.println("ingresa 2 para curarte tienes " + pote2 + " posiones");
                System.out.println("ingresa 3 para escapar");
                int elejire = s2.nextInt();
                switch (elejire) {
                    case 1:
                        //atacar
                        o2.atacarOrco(o);
                        System.out.println("Salud restante de " + o.getNombre() + " = " + o.getSalud());
                        break;
                    case 2:
                        //curar
                        if (pote2 > 0) {
                            o2.curarse();
                            pote2--;
                            System.out.println("has bebido una posion, tienes " + pote2 + " posiones mas");

                        } else {
                            System.out.println("Ya no te quedan posiones!");
                        }
                        break;
                    case 3:
                        //escapar
                        int proba = d1.tirarDado();
                        if (proba == 3) {
                            System.out.println("Lo graste escapar!");
                            o2.setSalud(0);
                            o.setSalud(0);
                        } else {
                            System.out.println("No has podido escapar!");
                        }
                        break;
                    default:
                }
                if (o.estaSaludable() == false) {
                    break;
                }

            }
        }
        
        //orco vs drake
          
        while (p1.getMes() == 2 && p2.getMes() == 3) {
            int tirada = d10.tirarDado();
            System.out.println("Dado = " + tirada);

            //ataca el player 1
            if (tirada > 5) {
                Scanner s1 = new Scanner(System.in);
                System.out.println(o.getNombre() + " tienes la oportunidad de atacar ! o tambien puedes hacer otras cosas....");
                System.out.println("ingresa 1 para atacar");
                System.out.println("ingresa 2 para curarte tienes " + pote1 + " posiones");
                System.out.println("ingresa 3 para escapar");
                int elejir = s1.nextInt();
                switch (elejir) {
                    case 1:
                        //atacar
                        o.atacarDrag(d);
                        System.out.println("Salud restante de " + d.getNombre() + " = " + d.getSalud());
                        break;
                    case 2:
                        //curar
                        if (pote1 > 0) {
                            o.curarse();
                            pote1--;
                            System.out.println("has bebido una posion, tienes " + pote1 + " posiones mas");

                        } else {
                            System.out.println("Ya no te quedan posiones!");
                        }
                    case 3:
                        //escapar
                        int proba = d1.tirarDado();
                        if (proba == 3) {
                            System.out.println("Lo graste escapar!");
                            o.setSalud(0);
                            d.setSalud(0);
                        } else {
                            System.out.println("No has podido escapar!");
                        }
                    default:
                }
                //c.atacarOrco(o); // atacar al player 2
                //System.out.println("Salud restante de " + o.getNombre()  +" = " + o.getSalud());
                if (d.estaSaludable() == false) {
                    break;
                }
            } //ataca el player 2
            else {
                Scanner s2 = new Scanner(System.in);
                System.out.println(d.getNombre() + " tienes la oportunidad de atacar ! o tambien puedes hacer otras cosas....");
                System.out.println("ingresa 1 para atacar");
                System.out.println("ingresa 2 para curarte tienes " + pote2 + " posiones");
                System.out.println("ingresa 3 para escapar");
                int elejire = s2.nextInt();
                switch (elejire) {
                    case 1:
                        //atacar
                        d.atacarOrco(o);
                        System.out.println("Salud restante de " + o.getNombre() + " = " + o.getSalud());
                        break;
                    case 2:
                        //curar
                        if (pote2 > 0) {
                            d.curarse();
                            pote2--;
                            System.out.println("has bebido una posion, tienes " + pote2 + " posiones mas");

                        } else {
                            System.out.println("Ya no te quedan posiones!");
                        }
                        break;
                    case 3:
                        //escapar
                        int proba = d1.tirarDado();
                        if (proba == 3) {
                            System.out.println("Lo graste escapar!");
                            d.setSalud(0);
                            o.setSalud(0);
                        } else {
                            System.out.println("No has podido escapar!");
                        }
                        break;
                    default:
                }
                if (o.estaSaludable() == false) {
                    break;
                }

            }
        }
               
        // drake vs caba
        
        while (p1.getMes() == 3 && p2.getMes() == 1) {
            int tirada = d10.tirarDado();
            System.out.println("Dado = " + tirada);

            //ataca el player 1
            if (tirada > 5) {
                Scanner s1 = new Scanner(System.in);
                System.out.println(d.getNombre() + " tienes la oportunidad de atacar ! o tambien puedes hacer otras cosas....");
                System.out.println("ingresa 1 para atacar");
                System.out.println("ingresa 2 para curarte tienes " + pote1 + " posiones");
                System.out.println("ingresa 3 para escapar");
                int elejir = s1.nextInt();
                switch (elejir) {
                    case 1:
                        //atacar
                        d.atacarCaba(c);
                        System.out.println("Salud restante de " + c.getNombre() + " = " + c.getSalud());
                        break;
                    case 2:
                        //curar
                        if (pote1 > 0) {
                            d.curarse();
                            pote1--;
                            System.out.println("has bebido una posion, tienes " + pote1 + " posiones mas");

                        } else {
                            System.out.println("Ya no te quedan posiones!");
                        }
                    case 3:
                        //escapar
                        int proba = d1.tirarDado();
                        if (proba == 3) {
                            System.out.println("Lo graste escapar!");
                            d.setSalud(0);
                            c.setSalud(0);
                        } else {
                            System.out.println("No has podido escapar!");
                        }
                    default:
                }
                //c.atacarOrco(o); // atacar al player 2
                //System.out.println("Salud restante de " + o.getNombre()  +" = " + o.getSalud());
                if (c.estaSaludable() == false) {
                    break;
                }
            } //ataca el player 2
            else {
                Scanner s2 = new Scanner(System.in);
                System.out.println(c.getNombre() + " tienes la oportunidad de atacar ! o tambien puedes hacer otras cosas....");
                System.out.println("ingresa 1 para atacar");
                System.out.println("ingresa 2 para curarte tienes " + pote2 + " posiones");
                System.out.println("ingresa 3 para escapar");
                int elejire = s2.nextInt();
                switch (elejire) {
                    case 1:
                        //atacar
                        c.atacarDrag(d);
                        System.out.println("Salud restante de " + d.getNombre() + " = " + d.getSalud());
                        break;
                    case 2:
                        //curar
                        if (pote2 > 0) {
                            c.curarse();
                            pote2--;
                            System.out.println("has bebido una posion, tienes " + pote2 + " posiones mas");

                        } else {
                            System.out.println("Ya no te quedan posiones!");
                        }
                        break;
                    case 3:
                        //escapar
                        int proba = d1.tirarDado();
                        if (proba == 3) {
                            System.out.println("Lo graste escapar!");
                            c.setSalud(0);
                            d.setSalud(0);
                        } else {
                            System.out.println("No has podido escapar!");
                        }
                        break;
                    default:
                }
                if (d.estaSaludable() == false) {
                    break;
                }

            }
        }
        //drake vs orco
        
        while (p1.getMes() == 3 && p2.getMes() == 2) {
            int tirada = d10.tirarDado();
            System.out.println("Dado = " + tirada);

            //ataca el player 1
            if (tirada > 5) {
                Scanner s1 = new Scanner(System.in);
                System.out.println(d.getNombre() + " tienes la oportunidad de atacar ! o tambien puedes hacer otras cosas....");
                System.out.println("ingresa 1 para atacar");
                System.out.println("ingresa 2 para curarte tienes " + pote1 + " posiones");
                System.out.println("ingresa 3 para escapar");
                int elejir = s1.nextInt();
                switch (elejir) {
                    case 1:
                        //atacar
                        d.atacarOrco(o);
                        System.out.println("Salud restante de " + o.getNombre() + " = " + o.getSalud());
                        break;
                    case 2:
                        //curar
                        if (pote1 > 0) {
                            d.curarse();
                            pote1--;
                            System.out.println("has bebido una posion, tienes " + pote1 + " posiones mas");

                        } else {
                            System.out.println("Ya no te quedan posiones!");
                        }
                    case 3:
                        //escapar
                        int proba = d1.tirarDado();
                        if (proba == 3) {
                            System.out.println("Lo graste escapar!");
                            d.setSalud(0);
                            o.setSalud(0);
                        } else {
                            System.out.println("No has podido escapar!");
                        }
                    default:
                }
                //c.atacarOrco(o); // atacar al player 2
                //System.out.println("Salud restante de " + o.getNombre()  +" = " + o.getSalud());
                if (o.estaSaludable() == false) {
                    break;
                }
            } //ataca el player 2
            else {
                Scanner s2 = new Scanner(System.in);
                System.out.println(o.getNombre() + " tienes la oportunidad de atacar ! o tambien puedes hacer otras cosas....");
                System.out.println("ingresa 1 para atacar");
                System.out.println("ingresa 2 para curarte tienes " + pote2 + " posiones");
                System.out.println("ingresa 3 para escapar");
                int elejire = s2.nextInt();
                switch (elejire) {
                    case 1:
                        //atacar
                        o.atacarDrag(d);
                        System.out.println("Salud restante de " + d.getNombre() + " = " + d.getSalud());
                        break;
                    case 2:
                        //curar
                        if (pote2 > 0) {
                            o.curarse();
                            pote2--;
                            System.out.println("has bebido una posion, tienes " + pote2 + " posiones mas");

                        } else {
                            System.out.println("Ya no te quedan posiones!");
                        }
                        break;
                    case 3:
                        //escapar
                        int proba = d1.tirarDado();
                        if (proba == 3) {
                            System.out.println("Lo graste escapar!");
                            o.setSalud(0);
                            d.setSalud(0);
                        } else {
                            System.out.println("No has podido escapar!");
                        }
                        break;
                    default:
                }
                if (d.estaSaludable() == false) {
                    break;
                }

            }
        }
        
        //drag vs drag
        
        while (p1.getMes() == 3 && p2.getMes() == 3) {
            int tirada = d10.tirarDado();
            System.out.println("Dado = " + tirada);

            //ataca el player 1
            if (tirada > 5) {
                Scanner s1 = new Scanner(System.in);
                System.out.println(d.getNombre() + " tienes la oportunidad de atacar ! o tambien puedes hacer otras cosas....");
                System.out.println("ingresa 1 para atacar");
                System.out.println("ingresa 2 para curarte tienes " + pote1 + " posiones");
                System.out.println("ingresa 3 para escapar");
                int elejir = s1.nextInt();
                switch (elejir) {
                    case 1:
                        //atacar
                        d.atacarDrag(d2);
                        System.out.println("Salud restante de " + d2.getNombre() + " = " + d2.getSalud());
                        break;
                    case 2:
                        //curar
                        if (pote1 > 0) {
                            d.curarse();
                            pote1--;
                            System.out.println("has bebido una posion, tienes " + pote1 + " posiones mas");

                        } else {
                            System.out.println("Ya no te quedan posiones!");
                        }
                    case 3:
                        //escapar
                        int proba = d1.tirarDado();
                        if (proba == 3) {
                            System.out.println("Lo graste escapar!");
                            d.setSalud(0);
                            d2.setSalud(0);
                        } else {
                            System.out.println("No has podido escapar!");
                        }
                    default:
                }
                //c.atacarOrco(o); // atacar al player 2
                //System.out.println("Salud restante de " + o.getNombre()  +" = " + o.getSalud());
                if (d2.estaSaludable() == false) {
                    break;
                }
            } //ataca el player 2
            else {
                Scanner s2 = new Scanner(System.in);
                System.out.println(d2.getNombre() + " tienes la oportunidad de atacar ! o tambien puedes hacer otras cosas....");
                System.out.println("ingresa 1 para atacar");
                System.out.println("ingresa 2 para curarte tienes " + pote2 + " posiones");
                System.out.println("ingresa 3 para escapar");
                int elejire = s2.nextInt();
                switch (elejire) {
                    case 1:
                        //atacar
                        d2.atacarDrag(d);
                        System.out.println("Salud restante de " + d.getNombre() + " = " + d.getSalud());
                        break;
                    case 2:
                        //curar
                        if (pote2 > 0) {
                            d2.curarse();
                            pote2--;
                            System.out.println("has bebido una posion, tienes " + pote2 + " posiones mas");

                        } else {
                            System.out.println("Ya no te quedan posiones!");
                        }
                        break;
                    case 3:
                        //escapar
                        int proba = d1.tirarDado();
                        if (proba == 3) {
                            System.out.println("Lo graste escapar!");
                            d2.setSalud(0);
                            d.setSalud(0);
                        } else {
                            System.out.println("No has podido escapar!");
                        }
                        break;
                    default:
                }
                if (d.estaSaludable() == false) {
                    break;
                }

            }
        }
        /*
        System.out.println("Esta será una batalla legendaria!");
        System.out.println("Combaten " + c.getNombre() + " y " + o.getNombre() + ".");
        System.out.println("Si el dado es mayor que 5\n ataca el caballero sino el orco");
        while (c.estaSaludable() && o.estaSaludable()) {
            int tirada = d10.tirarDado();
            System.out.println("Dado = " + tirada);
            if (tirada > 5) {
                c.atacar(o,d);
                System.out.println("Salud restante del orco = " + o.getSalud());
            } else {
                o.atacar(c,d);
                System.out.println("Salud restante del caballero = " + c.getSalud());
            }
        }
        System.out.println(d.getSalud());

        if (!c.estaSaludable()) {
            System.out.println("El orco ha vencido!");
            System.out.println(o.toString());
        } else { //!o.estaSaludable()
            System.out.println("El caballero ha ganado!");
            System.out.println(c.toString());
        }
         */
    }

}
