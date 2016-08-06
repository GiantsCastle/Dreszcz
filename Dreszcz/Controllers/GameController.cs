using Dreszcz.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using Microsoft.AspNet.Identity;
using System.Web.Mvc;
using System.Data.Entity;

namespace Dreszcz.Controllers
{
    [Authorize]
    public class GameController : Controller
    {
        private ApplicationDbContext db = new ApplicationDbContext();

        // GET: Game
        public ActionResult Index(string paragraf)
        {
            Character postac = (Character) Session["character"];
            if (postac == null)
            {
                var userId = User.Identity.GetUserId();
                postac = db.Characters.FirstOrDefault(c => c.ApplicationUserId == userId);
                Session["character"] = postac;
            }
            else
            {
                postac.paragraf = paragraf;
                db.SaveChanges();
            }

            if (postac.imie == null)
                RedirectToAction("Create");
            if (postac.paragraf != null )
                return View("paragraf" + paragraf, postac);
            else
                return View(postac);
        }


        public ActionResult Create()
        {
            var userId = User.Identity.GetUserId();
            Character postac = db.Characters.FirstOrDefault(c => c.ApplicationUserId == userId);

            return View(postac);
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create(Character postac)
        {
            if (ModelState.IsValid)
            {
                var userId = User.Identity.GetUserId();
                Character oryginal = db.Characters.FirstOrDefault(c => c.ApplicationUserId == userId);

                if (oryginal == null)
                {
                    return HttpNotFound();
                }

                oryginal.eliksir = postac.eliksir;
                oryginal.imie = postac.imie;
                oryginal.zrecznosc = postac.zrecznosc;
                oryginal.wytrzymalosc = postac.wytrzymalosc;
                oryginal.zrecznosc = postac.zrecznosc;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            else
            {
                return View(postac);
            }
        }
    }
}