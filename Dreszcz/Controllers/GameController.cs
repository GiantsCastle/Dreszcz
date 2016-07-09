using Dreszcz.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using Microsoft.AspNet.Identity;
using System.Web.Mvc;

namespace Dreszcz.Controllers
{
    public class GameController : Controller
    {
        private ApplicationDbContext db = new ApplicationDbContext();

        // GET: Game
        public ActionResult Index(int? paragraf)
        {
            var userId = User.Identity.GetUserId();
            Character postac = db.Characters.FirstOrDefault(c => c.ApplicationUserId == userId);

            if (paragraf != null)
                return View("paragraf" + paragraf, postac);
            else
                return View(postac);
        }
    }
}