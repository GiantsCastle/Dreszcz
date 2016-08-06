using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Dreszcz.Models
{
    public enum Eliksir { Zrecznosc, Wytrzymalosc, Szczescie, brak };

    public enum Przedmiot { miecz, tarcza, latarnia };

    [Serializable]
    public class Character
    {
        public int CharacterId { get; set; }

        public string Login { get; set; }

        public string imie { get; set; }

        public string paragraf { get; set; }

        public int zloto { get; set; }
        public int posilki { get; set; }

        public int zrecznosc { get; set; }
        public int wytrzymalosc { get; set; }
        public int szczescie { get; set; }

        //add character attributes here
        public Eliksir eliksir { get; set; }
        public List<Przedmiot> przedmioty { get; set; }

        //Zmienne
        public bool doorOpen { get; set; }

        public virtual ApplicationUser User { get; set; }
        public string ApplicationUserId { get; set; }

        public Character()
        {
            doorOpen = false;
            posilki = 8;
            zloto = 0;
            przedmioty = new List<Przedmiot>();
            przedmioty.Add(Przedmiot.miecz);
            przedmioty.Add(Przedmiot.tarcza);
            przedmioty.Add(Przedmiot.latarnia);
        }
    }
}