/**
 *
 * Copyright (C) 2012  Daniele Fani', Andrea Polini, Francesco De Angelis
 *
 * This file is part of ServicePot ver 0.1 .
 *
 * ServicePot is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with ServicePot.  If not, see <http:www.gnu.org/licenses/>.
 */
/**
 * Please modify this class to meet your needs This class is not complete
 */


package partes.service;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.ow2.choreos.registry.plugin.v2.CHOReOSPublishMonitor;


public class Activator implements BundleActivator
{

	@Override
	public void start(BundleContext bc) throws Exception 
	{
		PartesPlugin plugin = new PartesPlugin();
		bc.registerService(CHOReOSPublishMonitor.class, plugin, null);


	}

	@Override
	public void stop(BundleContext arg0) throws Exception 
	{
		// TODO Auto-generated method stub

	}

}
